package ManageView;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Color;

import java.awt.Font;
import javax.swing.JTextField;

import Dao.usersdao;

import base.BaseDao;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class resistview {

	private JFrame frame;
	private JTextField textfield_username;
	private JTextField textfield_password;
	private JTextField textField_ygjs;
	private JTextField textField_sex;
	private JTextField textField_id;
	private Objective.users user1 = new Objective.users();

	/**
	 * Create the application.
	 */
	public resistview() {
		initialize();
	}

	private void add() {
		usersdao userdao = (usersdao) BaseDao.getAbilityDAO(Objective.DAO.users);
		user1.setId(Integer.parseInt(textField_id.getText()));
		user1.setName(textfield_username.getText());
		user1.setPassword(textfield_password.getText());
		user1.setType(textField_ygjs.getText());
		user1.setSex(textField_sex.getText());
		userdao.add(user1);
	}

	/**
	 * } Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);

		frame.setTitle("\u7528\u6237\u6CE8\u518C");
		frame.setBounds(100, 100, 597, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\u6B22\u8FCE\u6CE8\u518C\u672C\u7CFB\u7EDF\u8D26\u53F7");
		label.setFont(new Font("楷体", Font.PLAIN, 20));
		label.setForeground(Color.RED);
		label.setBounds(120, 10, 180, 48);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("  \u59D3 \u540D");
		label_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		label_1.setBounds(34, 73, 75, 15);
		frame.getContentPane().add(label_1);

		textfield_username = new JTextField();
		textfield_username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textfield_username.setBounds(120, 68, 87, 21);
		frame.getContentPane().add(textfield_username);
		textfield_username.setColumns(10);

		JLabel label_2 = new JLabel("  \u5BC6 \u7801");
		label_2.setFont(new Font("华文楷体", Font.PLAIN, 18));
		label_2.setBounds(34, 118, 75, 15);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("  \u6743 \u9650");
		label_3.setFont(new Font("华文楷体", Font.PLAIN, 18));
		label_3.setBounds(34, 161, 75, 15);
		frame.getContentPane().add(label_3);

		textfield_password = new JTextField();
		textfield_password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textfield_password.setColumns(10);
		textfield_password.setBounds(120, 116, 87, 21);
		frame.getContentPane().add(textfield_password);

		textField_ygjs = new JTextField();
		textField_ygjs.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		JLabel lblID = new JLabel("  i d");
		lblID.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblID.setBounds(120, 204, 75, 15);
		frame.getContentPane().add(lblID);

		textField_id = new JTextField();
		textField_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textField_id.setColumns(10);
		textField_id.setBounds(165, 198, 66, 21);
		frame.getContentPane().add(textField_id);

		textField_ygjs.setColumns(10);
		textField_ygjs.setBounds(120, 159, 87, 21);
		frame.getContentPane().add(textField_ygjs);

		JLabel label_4 = new JLabel("  \u6027 \u522B");
		label_4.setFont(new Font("华文楷体", Font.PLAIN, 18));
		label_4.setBounds(0, 204, 75, 15);
		frame.getContentPane().add(label_4);

		textField_sex = new JTextField();
		textField_sex.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textField_sex.setColumns(10);
		textField_sex.setBounds(57, 202, 54, 21);
		frame.getContentPane().add(textField_sex);
		JButton button = new JButton("\u6CE8\u518C");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add();
				frame.dispose();
				new Loginview();
			}
		});
		button.setBounds(34, 282, 93, 23);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				frame.dispose();
				new Loginview();

			}

		});

		button_1.setBounds(464, 295, 93, 23);
		frame.getContentPane().add(button_1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(resistview.class.getResource("/img/logo.jpg")));
		lblNewLabel.setBounds(488, 1, 93, 70);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_5 = new JLabel("\u6743\u9650\u8BF4\u660E\uFF1A");
		label_5.setFont(new Font("华文楷体", Font.PLAIN, 16));
		label_5.setBounds(339, 65, 134, 30);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u8F93\u51651  ----  \u4E1A\u52A1\u5458");
		label_6.setBounds(339, 111, 134, 30);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("\u8F93\u51652  ----  \u7BA1\u7406\u5458");
		label_7.setBounds(339, 154, 134, 30);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("\u8F93\u51653  ----  \u987E\u5BA2");
		label_8.setBounds(339, 197, 134, 30);
		frame.getContentPane().add(label_8);

	}
}
