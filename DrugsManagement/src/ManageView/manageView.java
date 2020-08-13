package ManageView;

import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class manageView {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public manageView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("\u7BA1\u7406\u5458\u754C\u9762");
		frame.setBounds(100, 100, 638, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton adduser = new JButton("\u7528\u6237\u6CE8\u518C");

		adduser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new resistview();
			}
		});
		adduser.setBounds(10, 10, 105, 30);
		frame.getContentPane().add(adduser);

		JButton deleteuser = new JButton("\u7528\u6237\u5220\u9664");
		deleteuser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new ManageUserDeleteView();
			}
		});
		deleteuser.setBounds(10, 71, 105, 30);
		frame.getContentPane().add(deleteuser);

		JButton adddrugs = new JButton("\u65B0\u836F\u54C1\u5165\u5E93");
		adddrugs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ManageAddNewView();
			}
		});
		adddrugs.setBounds(10, 131, 105, 30);
		frame.getContentPane().add(adddrugs);

		JButton deletedrugs = new JButton("\u836F\u54C1\u51FA\u5E93");
		deletedrugs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new ManageDeleteDrugsView();
			}
		});
		deletedrugs.setBounds(327, 71, 105, 30);
		frame.getContentPane().add(deletedrugs);

		JButton querydrugs = new JButton("\u5E93\u5B58\u67E5\u8BE2");
		querydrugs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new Managedrugsshowview();
			}
		});
		querydrugs.setBounds(327, 10, 105, 30);
		frame.getContentPane().add(querydrugs);

		JButton getin = new JButton("\u5165\u5E93\u62A5\u8868");
		getin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new ManageGetinShowView();
			}
		});
		getin.setBounds(327, 133, 105, 27);
		frame.getContentPane().add(getin);

		JButton getout = new JButton("\u51FA\u5E93\u62A5\u8868");
		getout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new ManageGetoutShowView();
			}
		});
		getout.setBounds(327, 197, 105, 27);
		frame.getContentPane().add(getout);

		JButton button = new JButton("\u9000\u51FA\u767B\u5F55");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new Loginview();
			}
		});
		button.setBounds(519, 299, 93, 23);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\u5DF2\u6709\u836F\u54C1\u5165\u5E93");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new ManageAddOldView();
			}
		});
		button_1.setBounds(10, 195, 117, 30);
		frame.getContentPane().add(button_1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(manageView.class.getResource("/img/logo.jpg")));
		lblNewLabel.setBounds(519, 11, 93, 66);
		frame.getContentPane().add(lblNewLabel);
	}
}
