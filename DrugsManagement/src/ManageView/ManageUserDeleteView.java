package ManageView;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import Dao.usersdao;
import base.BaseDao;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class ManageUserDeleteView {

	private JFrame frame;
	private JTextField textField_name;
	private JTextField textField_sex;
	private JTextField textField_password;
	private JTextField textField_ygjs;
	private JTextField textField_id;
	private Objective.users user1 = new Objective.users();

	private void delete() {
		usersdao userdao = (usersdao) BaseDao.getAbilityDAO(Objective.DAO.users);
		user1.setId(Integer.parseInt(textField_id.getText()));
		userdao.delete(user1);
	}

	/**
	 * Create the application.
	 */
	public ManageUserDeleteView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7BA1\u7406\u5458\u5220\u9664\u7528\u6237\u754C\u9762");
		frame.setVisible(true);
		frame.setBounds(100, 100, 621, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton button_delete = new JButton("\u5220\u9664");
		button_delete.setBounds(33, 311, 93, 34);
		frame.getContentPane().add(button_delete);

		JLabel label = new JLabel("   \u59D3\u540D");
		label.setForeground(Color.MAGENTA);
		label.setFont(new Font("楷体", Font.PLAIN, 17));
		label.setBounds(24, 82, 61, 15);
		frame.getContentPane().add(label);

		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBackground(SystemColor.activeCaption);
		textField_name.setBounds(100, 80, 78, 21);
		frame.getContentPane().add(textField_name);

		JLabel label_1 = new JLabel(" \u6027\u522B");
		label_1.setForeground(Color.MAGENTA);
		label_1.setFont(new Font("楷体", Font.PLAIN, 17));
		label_1.setBounds(44, 162, 52, 15);
		frame.getContentPane().add(label_1);

		textField_sex = new JTextField();
		textField_sex.setColumns(10);
		textField_sex.setBackground(SystemColor.activeCaption);
		textField_sex.setBounds(100, 160, 78, 21);
		frame.getContentPane().add(textField_sex);

		JLabel label_2 = new JLabel("   \u5BC6\u7801");
		label_2.setForeground(Color.MAGENTA);
		label_2.setFont(new Font("楷体", Font.PLAIN, 17));
		label_2.setBounds(24, 248, 72, 15);
		frame.getContentPane().add(label_2);

		textField_password = new JTextField();
		textField_password.setColumns(10);
		textField_password.setBackground(SystemColor.activeCaption);
		textField_password.setBounds(100, 246, 78, 21);
		frame.getContentPane().add(textField_password);

		JLabel label_3 = new JLabel("  \u6743\u9650");
		label_3.setForeground(Color.MAGENTA);
		label_3.setFont(new Font("楷体", Font.PLAIN, 17));
		label_3.setBounds(287, 109, 60, 15);
		frame.getContentPane().add(label_3);

		textField_ygjs = new JTextField();
		textField_ygjs.setColumns(10);
		textField_ygjs.setBackground(SystemColor.activeCaption);
		textField_ygjs.setBounds(363, 107, 78, 21);
		frame.getContentPane().add(textField_ygjs);

		JLabel label_4 = new JLabel("  \u7F16\u53F7");
		label_4.setForeground(Color.MAGENTA);
		label_4.setFont(new Font("楷体", Font.PLAIN, 17));
		label_4.setBounds(287, 203, 60, 15);
		frame.getContentPane().add(label_4);

		textField_id = new JTextField();
		textField_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				delete();
				frame.dispose();
				new manageView();

			}
		});
		textField_id.setColumns(10);
		textField_id.setBackground(SystemColor.activeCaption);
		textField_id.setBounds(363, 201, 78, 21);
		frame.getContentPane().add(textField_id);

		JButton button_cacel = new JButton("\u53D6\u6D88\u5220\u9664");
		button_cacel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new manageView();
			}
		});
		button_cacel.setBounds(431, 311, 93, 34);
		frame.getContentPane().add(button_cacel);
		
		JLabel lblTips = new JLabel("tips\uFF1A\u5220\u9664\u6709\u98CE\u9669\uFF0C\u70B9\u51FB\u9700\u8C28\u614E");
		lblTips.setForeground(Color.RED);
		lblTips.setFont(new Font("华文行楷", Font.PLAIN, 24));
		lblTips.setBounds(68, 10, 373, 47);
		frame.getContentPane().add(lblTips);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ManageUserDeleteView.class.getResource("/img/logo.jpg")));
		lblNewLabel.setBounds(502, 10, 93, 71);
		frame.getContentPane().add(lblNewLabel);
	}
}
