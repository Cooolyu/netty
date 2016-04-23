package com.gmyl.eparking.client;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.gmyl.eparking.client.handler.NettyClientHandler;
import com.gmyl.eparking.gui.MenuGui;
import com.gmyl.eparking.message.BillSend;
import com.gmyl.eparking.message.CancelOrdSend;
import com.gmyl.eparking.message.Constants;
import com.gmyl.eparking.message.LoginMsg;
import com.gmyl.eparking.message.PaySend;
import com.gmyl.eparking.message.PromotSend;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

public class NettyClientBootstrap {

	    private int port;
	    private String host;
	    public SocketChannel socketChannel;
	    private static final EventExecutorGroup group = new DefaultEventExecutorGroup(20);
	    public NettyClientBootstrap(int port, String host) throws InterruptedException {
	        this.port = port;
	        this.host = host;
	        start();
	    }
	    private void start() throws InterruptedException {
	        EventLoopGroup eventLoopGroup=new NioEventLoopGroup();
	        Bootstrap bootstrap=new Bootstrap();
	        bootstrap.channel(NioSocketChannel.class);
	        bootstrap.option(ChannelOption.SO_KEEPALIVE,true);
	        bootstrap.group(eventLoopGroup);
	        bootstrap.remoteAddress(host,port);
	        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
	            @Override
	            protected void initChannel(SocketChannel socketChannel) throws Exception {
	                socketChannel.pipeline().addLast(new IdleStateHandler(20,10,0));
	                socketChannel.pipeline().addLast(new ObjectEncoder());
	                socketChannel.pipeline().addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
	                socketChannel.pipeline().addLast(new NettyClientHandler());
	            }
	        });
	        ChannelFuture future =bootstrap.connect(host,port).sync();
	        if (future.isSuccess()) {
	            socketChannel = (SocketChannel)future.channel();
	            System.out.println("connect server  成功---------");
	        }
	    }
//	    public static void main(String[]args) throws InterruptedException {
//	        Constants.setClientId("101");
//	        NettyClientBootstrap bootstrap=new NettyClientBootstrap(9999,"127.0.0.1");
//	        LoginMsg loginMsg=new LoginMsg();
//	        loginMsg.setPassword("yao");
//	        loginMsg.setUserName("robin1");
//	        bootstrap.socketChannel.writeAndFlush(loginMsg);
//	        while (true){
//	            TimeUnit.SECONDS.sleep(15);
//	            
//	            Random rd = new Random();
//	            //车牌数组
//	            String[] array = {"苏","粤","沪"}; 
//	            
//	            //取消预约
//	            System.out.println("--------开始取消预约---------");
//	            MenuGui menuGui = new MenuGui();
//	            menuGui.setTemp("hehehehheheh");
//	            CancelOrdSend cancelOrdSend = new CancelOrdSend();
//	            cancelOrdSend.setClientId(Constants.getClientId());
//	            cancelOrdSend.setCarNum(""+array[rd.nextInt(2)]+rd.nextInt(10)+rd.nextInt(10)+rd.nextInt(10)+rd.nextInt(10)+rd.nextInt(10)+rd.nextInt(10));
//	            cancelOrdSend.setOrderNum(rd.nextInt(100));
//	            bootstrap.socketChannel.writeAndFlush(cancelOrdSend);
//	            
//	            //计费
//	            TimeUnit.SECONDS.sleep(5);
//	            System.out.println("--------开始计费---------");
//	            BillSend billSend = new BillSend();
//	            billSend.setCarNum(""+array[rd.nextInt(2)]+rd.nextInt(10)+rd.nextInt(10)+rd.nextInt(10)+rd.nextInt(10)+rd.nextInt(10)+rd.nextInt(10));
//	            billSend.setClientId(Constants.getClientId());
//	            bootstrap.socketChannel.writeAndFlush(billSend);
//	            
//	            	//支付
//	            TimeUnit.SECONDS.sleep(5);
//	            System.out.println("--------开始支付---------");
//	            PaySend paySend = new PaySend();
//	            paySend.setClientId(Constants.getClientId());
//	            paySend.setOrderNum(rd.nextInt(100));
//	            paySend.setCarNum(""+array[rd.nextInt(2)]+rd.nextInt(10)+rd.nextInt(10)+rd.nextInt(10)+rd.nextInt(10)+rd.nextInt(10)+rd.nextInt(10));
//	            paySend.setPayTime(System.currentTimeMillis());
//	            paySend.setMoney(100);
//	            bootstrap.socketChannel.writeAndFlush(paySend);
//	            
//	            //优惠策略
//	            TimeUnit.SECONDS.sleep(5);
//	            System.out.println("--------开始优惠策略---------");
//	            PromotSend promotSend = new PromotSend();
//	            promotSend.setClientId(Constants.getClientId());
//	            promotSend.setPromotType(rd.nextInt(3));
//	            promotSend.setUserIdentity("1");
//	            promotSend.setPromotcontent(rd.nextInt(3));
//	            bootstrap.socketChannel.writeAndFlush(promotSend);
//	            
//	        }
//	    }
}
