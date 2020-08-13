package ManageView;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

import BusinessView.BusinessView;
import CustomView.CustomVew;
import Dao.usersdao;
import base.BaseDao;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class Loginview {

	private JFrame frame;
	private JTextField username;
	private JTextField password;

	/**
	 * Create the application.
	 */
	public Loginview() {
		initialize();
	}

	private void check() {
		usersdao userDAO = (usersdao) BaseDao.getAbilityDAO(Objective.DAO.users);

		switch (userDAO.queryLogin(username.getText(), password.getText())) {

		case "1":
			frame.dispose();
			new BusinessView();
			break;
		case "2":
			frame.dispose();
			new manageView();
			break;
		case "3":
			frame.dispose();
			new CustomVew();
			break;
		default:
			username.setText("");
			password.setText("");
			break;
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		

		JLabel label_user = new JLabel(" \u59D3   \u540D");
		label_user.setForeground(Color.BLUE);
		label_user.setFont(new Font("华文行楷", Font.PLAIN, 20));
		label_user.setBounds(154, 90, 77, 26);
		frame.getContentPane().add(label_user);
		frame.setBounds(0, 0, 50, 50);

		JLabel label_password = new JLabel("  \u5BC6   \u7801");
		label_password.setForeground(Color.BLUE);
		label_password.setFont(new Font("华文行楷", Font.PLAIN, 20));
		label_password.setBounds(154, 140, 65, 25);
		frame.getContentPane().add(label_password);
		
		
		frame.setTitle("药房管理系统");
		frame.setBounds(100, 100, 472, 319);
		frame.getContentPane().setLayout(null);

		username = new JTextField();
		username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					check();
				}
			}
		});
		username.setBounds(259, 91, 108, 26);
		frame.getContentPane().add(username);
		username.setColumns(10);

		password = new JPasswordField();
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					check();
				}

			}
		});
		password.setColumns(10);
		password.setBounds(259, 140, 108, 25);
		frame.getContentPane().add(password);

		JButton enter = new JButton("\u767B\u5F55");
		enter.setForeground(new Color(204, 0, 255));
		enter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				check();
			}
		});
		enter.setBounds(104, 229, 93, 23);
		frame.getContentPane().add(enter);

		JButton resist = new JButton("\u6CE8\u518C");
		resist.setForeground(new Color(204, 51, 204));
		resist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new resistview();
			}
		});
		resist.setBounds(313, 229, 93, 23);
		frame.getContentPane().add(resist);

		JLabel label = new JLabel("0");
		label.setIcon(new ImageIcon(Loginview.class.getResource("/img/logo.jpg")));
		label.setBounds(10, 10, 93, 85);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u672C\u7CFB\u7EDF");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("华文行楷", Font.PLAIN, 32));
		label_1.setBounds(154, 21, 279, 57);
		frame.getContentPane().add(label_1);
		frame.setVisible(true);
	}
}
