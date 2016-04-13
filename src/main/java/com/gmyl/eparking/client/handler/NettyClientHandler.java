package com.gmyl.eparking.client.handler;

import java.util.Date;

import com.gmyl.eparking.message.BaseMsg;
import com.gmyl.eparking.message.Constants;
import com.gmyl.eparking.message.CwyyMsg;
import com.gmyl.eparking.message.CwyyReplyMsg;
import com.gmyl.eparking.message.JCSJReplyMSG;
import com.gmyl.eparking.message.JcsjMsg;
import com.gmyl.eparking.message.LoginMsg;
import com.gmyl.eparking.message.LoginReplyMsg;
import com.gmyl.eparking.message.MsgType;
import com.gmyl.eparking.message.PingMsg;
import com.gmyl.eparking.message.ReplyClientBody;
import com.gmyl.eparking.message.ReplyMsg;
import com.gmyl.eparking.message.ReplyServerBody;
import com.gmyl.eparking.pojo.CancelOrdReceive;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;

public class NettyClientHandler extends SimpleChannelInboundHandler<BaseMsg>{

    //利用写空闲发送心跳检测消息
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case WRITER_IDLE:
                    PingMsg pingMsg=new PingMsg();
                    ctx.writeAndFlush(pingMsg);
                    System.out.println("send ping to server userEventTriggered --------"+new Date());
                    break;
                default:
                    break;
            }
        }
    }
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, BaseMsg baseMsg) throws Exception {
        MsgType msgType=baseMsg.getType();
        switch (msgType){
	        case CWYY:{
	            CwyyMsg msg=(CwyyMsg)baseMsg;
	            System.out.println("receive server msg: "+msg.toString());
	            CwyyReplyMsg replaymsg=new CwyyReplyMsg();
	            replaymsg.setResult("0");
	            replaymsg.setKyycdzcw("1");
	            replaymsg.setKyyptcw("10");
                //System.out.println("login clientID:"+ loginMsg.getClientId());
                channelHandlerContext.writeAndFlush(replaymsg);
	        }break;
	        case JCSJ_REPLY:{
	            JCSJReplyMSG replyMsg=(JCSJReplyMSG)baseMsg;
	            System.out.println("receive client msg: "+replyMsg.toString());
	        }break;
            case LOGIN:{
                //向服务器发起登录
            	Constants.setClientId("101");
                LoginMsg loginMsg=new LoginMsg();
                loginMsg.setPassword("yao");
                loginMsg.setUserName("robin");
                System.out.println("login clientID:"+ loginMsg.getClientId());
                channelHandlerContext.writeAndFlush(loginMsg);
            }break;
            
            case QXYY:{
            		CancelOrdReceive cancelOrdReceive=(CancelOrdReceive)baseMsg;
            		System.out.println("myLog start ----"+cancelOrdReceive.getResult());
            }break;
            
            
            
            
            
            
            case PING:{
                System.out.println("receive ping from server----------"+new Date());
            }break;
            case ASK:{
                ReplyClientBody replyClientBody=new ReplyClientBody("client info **** !!!");
                ReplyMsg replyMsg=new ReplyMsg();
                replyMsg.setBody(replyClientBody);
                channelHandlerContext.writeAndFlush(replyMsg);
            }break;
            case REPLY:{
                ReplyMsg replyMsg=(ReplyMsg)baseMsg;
                ReplyServerBody replyServerBody=(ReplyServerBody)replyMsg.getBody();
                System.out.println("receive client msg: "+replyServerBody.getServerInfo());
            }break;
            case LOGIN_REPLY:{
            	//ReplyClientBody replyClientBody=new ReplyClientBody("client info **** !!!");
                
            	LoginReplyMsg loginReplyMsg = (LoginReplyMsg)baseMsg;
            	Constants.setClientId(loginReplyMsg.getLoginToken());
            }break;
            
            default:break;
        }
        ReferenceCountUtil.release(msgType);
    }
}
