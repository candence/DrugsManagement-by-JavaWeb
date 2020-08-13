package CustomView;

import javax.swing.JFrame;

import ManageView.Loginview;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class CustomVew {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public CustomVew() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("\u987E\u5BA2\u754C\u9762");
		frame.setBounds(100, 100, 608, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton querydrugs = new JButton("\u5E93\u5B58\u67E5\u8BE2");
		querydrugs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new CustomDrugsShowView();
			}
		});
		querydrugs.setBounds(58, 208, 105, 30);
		frame.getContentPane().add(querydrugs);

		JButton button = new JButton("\u836F\u54C1\u8D2D\u4E70");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new CustonDrugsGetoutView();
			}
		});
		button.setBounds(317, 208, 105, 30);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\u9000\u51FA\u767B\u5F55");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new Loginview();
			}
		});
		button_1.setBounds(447, 346, 105, 30);
		frame.getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CustomVew.class.getResource("/img/logo.jpg")));
		lblNewLabel.setBounds(482, 10, 100, 84);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u8FDB\u5E97\u9009\u8D2D");
		label.setForeground(Color.RED);
		label.setFont(new Font("»ªÎÄÐÐ¿¬", Font.PLAIN, 30));
		label.setBounds(157, 77, 233, 84);
		frame.getContentPane().add(label);
	}
}
