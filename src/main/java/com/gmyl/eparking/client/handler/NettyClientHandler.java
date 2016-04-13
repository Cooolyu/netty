package com.gmyl.eparking.client.handler;

import java.util.Date;

import com.gmyl.eparking.message.BaseMsg;
import com.gmyl.eparking.message.Constants;
import com.gmyl.eparking.message.LoginMsg;
import com.gmyl.eparking.message.MsgType;
import com.gmyl.eparking.message.PingMsg;
import com.gmyl.eparking.pojo.BillResp;
import com.gmyl.eparking.pojo.BillSend;
import com.gmyl.eparking.pojo.CancelOrdResp;
import com.gmyl.eparking.pojo.PayResp;
import com.gmyl.eparking.pojo.PromotResp;

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
            		//取消预约
            		CancelOrdResp cancelOrdReceive=(CancelOrdResp)baseMsg;
            		if (cancelOrdReceive.getResult() == 0) {
            			System.out.println("取消预约成功");
				}else{
					System.out.println("取消预约失败");
				}
            }break;
            
            case JF:{
            		//计费
            		BillResp billResp = (BillResp)baseMsg;
            		if(billResp.getResult() == 0){
            			System.out.println("计费成功----"
            								+"订单号:"+billResp.getOrderNum()
            								+"需付金额:"+billResp.getPayMoney()
            								+"入场时间:"+billResp.getEnterTime()
            								+"停车时长:"+billResp.getParkTime());
            		}else{
            			System.out.println("计费失败");
            		}
            }break;
            
            case ZF:{
        			//支付
        			PayResp payResp = (PayResp)baseMsg;
        			if (payResp.getResult() == 0) {
        				System.out.println("支付成功");
        			}else{
        				System.out.println("支付失败");
        			}
            }break;
            
            case YHCL:{
            		//优惠策略
            		PromotResp promotResp = (PromotResp)baseMsg;
            		if(promotResp.getResult() == 0){
            			System.out.println("优惠策略成功");
            		}else {
						System.out.println("优惠策略失败");
				}
            }
            
            
            
            
            
            default:break;
        }
        ReferenceCountUtil.release(msgType);
    }
}
