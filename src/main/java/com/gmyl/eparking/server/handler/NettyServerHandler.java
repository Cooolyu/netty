package com.gmyl.eparking.server.handler;

import java.util.Random;

import com.gmyl.eparking.gui.ServerGui;
import com.gmyl.eparking.message.BaseMsg;
import com.gmyl.eparking.message.BillResp;
import com.gmyl.eparking.message.BillSend;
import com.gmyl.eparking.message.CancelOrdResp;
import com.gmyl.eparking.message.CancelOrdSend;
import com.gmyl.eparking.message.LoginMsg;
import com.gmyl.eparking.message.LoginReplyMsg;
import com.gmyl.eparking.message.MsgType;
import com.gmyl.eparking.message.PayResp;
import com.gmyl.eparking.message.PaySend;
import com.gmyl.eparking.message.PromotResp;
import com.gmyl.eparking.message.PromotSend;
import com.gmyl.eparking.server.NettyChannelMap;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.ReferenceCountUtil;

public class NettyServerHandler extends SimpleChannelInboundHandler<BaseMsg> {

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //channel失效，从Map中移除
        NettyChannelMap.remove((SocketChannel)ctx.channel());
    }
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, BaseMsg baseMsg) throws Exception {
 
        if(MsgType.LOGIN.equals(baseMsg.getType())){
        	ServerGui serverGui = new ServerGui(); 
            LoginMsg loginMsg=(LoginMsg)baseMsg;
            if("robin".equals(loginMsg.getUserName())&&"yao".equals(loginMsg.getPassword())){
            	//登录成功,把channel存到服务端的map中
                String loginToken = NettyChannelMap.add(loginMsg.getClientId(),(SocketChannel)channelHandlerContext.channel());
                System.out.println("client"+loginMsg.getUserName()+" 登录成功");
                LoginReplyMsg loginReplyMsg = new LoginReplyMsg();
                loginReplyMsg.setSuccese(true);
                loginReplyMsg.setLoginToken(loginToken);
                channelHandlerContext.channel().writeAndFlush(loginReplyMsg);
            }else{
            	 System.out.println("client"+loginMsg.getUserName()+" 登录失败");
            	 LoginReplyMsg loginReplyMsg = new LoginReplyMsg();
            	 loginReplyMsg.setSuccese(false);
                 //loginReplyMsg.setLoginToken(loginToken);
                 channelHandlerContext.channel().writeAndFlush(loginReplyMsg);
            }
            return;
        }else{
        	String clientId = baseMsg.getClientId();
        	if(clientId == null){
        		 //说明未登录，或者连接断了，服务器向客户端发起登录请求，让客户端重新登录
                LoginMsg loginMsg=new LoginMsg();
                channelHandlerContext.channel().writeAndFlush(loginMsg);
        		return ;
        	}
        	Channel channel = NettyChannelMap.get(clientId);
            if(channel==null){
                    //说明未登录，或者连接断了，服务器向客户端发起登录请求，让客户端重新登录
                    LoginMsg loginMsg=new LoginMsg();
                    channelHandlerContext.channel().writeAndFlush(loginMsg);
                    return;
            }
            
            Channel currentChannel = channelHandlerContext.channel();
            if(currentChannel != channel){
            	 //登陆id不匹配
                LoginMsg loginMsg=new LoginMsg();
                channelHandlerContext.channel().writeAndFlush(loginMsg);
                return;
            }
            
            
        }
        switch (baseMsg.getType()){       
            case QXYY:{
                //取消预约
            		//接收客户端发送的数据
                CancelOrdSend cancelOrdSend = (CancelOrdSend)baseMsg;
                System.out.println("正在取消预约-----"+"车牌号"+cancelOrdSend.getCarNum()+"订单号"+cancelOrdSend.getOrderNum());
                CancelOrdResp cancelOrdResp = new CancelOrdResp();
                Random rd = new Random();
                cancelOrdResp.setResult(rd.nextInt(2));
                NettyChannelMap.get(cancelOrdSend.getClientId()).writeAndFlush(cancelOrdResp);
            }break;
            
            case JF:{
            		//计费
            		//接收客户端发送的数据
            		BillSend billSend = (BillSend)baseMsg;
            		System.out.println("正在进行计费------"
            							+"计费的车牌号:"+billSend.getCarNum());
            		BillResp billResp = new BillResp();
            		Random rd = new Random();
            		billResp.setResult(rd.nextInt(2));
            		billResp.setOrderNum(rd.nextInt(100));
            		billResp.setPayMoney(rd.nextInt(100));
            		billResp.setEnterTime(System.currentTimeMillis());
            		billResp.setParkTime(rd.nextInt(10));
                NettyChannelMap.get(billSend.getClientId()).writeAndFlush(billResp);
            }break;
            
            case ZF:{
            		//支付
            	    //接收客户端发送的数据
            		PaySend paySend = (PaySend)baseMsg;
            		System.out.println("正在进行支付------"
            							+"车牌号:"+paySend.getCarNum()
            							+"订单号:"+paySend.getOrderNum()
            							+"付费时长"+paySend.getPayTime()
            							+"金额:"+paySend.getMoney());
            		Random rd = new Random();
            		PayResp payResp = new PayResp();
            		payResp.setResult(rd.nextInt(2));
            		NettyChannelMap.get(paySend.getClientId()).writeAndFlush(payResp);
            }break;
            
            case YHCL:{
            		//优惠策略
            		PromotSend promotSend = (PromotSend)baseMsg;
            		System.out.println("正在进行优惠策略------"
            							+"用户身份:"+promotSend.getUserIdentity()
            							+"优惠类型:"+promotSend.getPromotType()
            							+"优惠内容:"+promotSend.getPromotcontent());
            		Random rd = new Random();
            		PromotResp promotResp = new PromotResp();
            		promotResp.setResult(rd.nextInt(2));
            		NettyChannelMap.get(promotSend.getClientId()).writeAndFlush(promotResp);
            }break;
            
            
            case LOGOUT:{
            	NettyChannelMap.remove((SocketChannel)channelHandlerContext.channel());
            	
            }break;
            
            default:break;
        }
        ReferenceCountUtil.release(baseMsg);
    }
}
