package BusinessView;

import javax.swing.JFrame;

import ManageView.Loginview;
import ManageView.ManageAddOldView;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class BusinessView {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public BusinessView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("\u4E1A\u52A1\u5458\u754C\u9762");
		frame.setBounds(100, 100, 628, 412);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton adddrugs = new JButton("\u65B0\u836F\u54C1\u5165\u5E93");
		adddrugs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new BusinessAddNewView();
			}
		});
		adddrugs.setBounds(107, 186, 105, 30);
		frame.getContentPane().add(adddrugs);

		JButton deletedrugs = new JButton("\u836F\u54C1\u51FA\u5E93");
		deletedrugs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new BusinessDeleteDrugsView();
			}
		});
		deletedrugs.setBounds(314, 95, 105, 30);
		frame.getContentPane().add(deletedrugs);

		JButton querydrugs = new JButton("\u5E93\u5B58\u67E5\u8BE2");
		querydrugs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new Businessdrugsshowview();
			}
		});
		querydrugs.setBounds(107, 95, 105, 30);
		frame.getContentPane().add(querydrugs);

		JButton getin = new JButton("\u5165\u5E93\u62A5\u8868");
		getin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new BusinessGetinShowView();
			}
		});
		getin.setBounds(314, 266, 105, 27);
		frame.getContentPane().add(getin);

		JButton getout = new JButton("\u51FA\u5E93\u62A5\u8868");
		getout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new BusinessGetOutShowView();
			}
		});
		getout.setBounds(107, 266, 105, 27);
		frame.getContentPane().add(getout);

		JButton button = new JButton("\u9000\u51FA\u767B\u5F55");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new Loginview();
			}
		});
		button.setBounds(509, 341, 93, 23);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\u5DF2\u6709\u836F\u54C1\u5165\u5E93");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new BusinessAddOldView();
			}
		});
		button_1.setBounds(302, 186, 117, 30);
		frame.getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ManageAddOldView.class.getResource("/img/logo.jpg")));
		lblNewLabel.setBounds(503, 10, 99, 73);
		frame.getContentPane().add(lblNewLabel);
	}
}
