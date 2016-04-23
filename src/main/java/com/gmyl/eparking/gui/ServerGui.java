package com.gmyl.eparking.gui;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class ServerGui {

	private JFrame frmAgent;

	/**
	 * Launch the application.
	 */
	public void create() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerGui window = new ServerGui();
					window.frmAgent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ServerGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgent = new JFrame();
		frmAgent.setTitle("Agent停车场服务端V1.0");
		frmAgent.setBounds(100, 100, 450, 300);
		frmAgent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextPane textPane = new JTextPane();
		
		//接收客户端信息
//		try {
//			Runnable runnable = new Runnable() {
//
//				public void run() {
//					while (true) {
//						getMesg(nettyServerHandler, textPane);
//						try {
//							Thread.sleep(1000);
//						} catch (Exception e) {
//							e.getMessage();
//						}
//					}
//				}
//			};
//			Thread thread = new Thread(runnable);
//			thread.start();


//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		
		
		
		
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frmAgent.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
		);
		frmAgent.getContentPane().setLayout(groupLayout);
	}
	

}
