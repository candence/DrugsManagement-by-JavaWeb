package ManageView;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import Dao.drugsDao;
import Dao.getindao;
import base.BaseDao;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class ManageAddOldView {

	private JFrame frame;
	private JTextField textField_id;
	private JTextField textField_number;
	private JButton button_;
	private JButton button_1cancel;
	private JButton button_return;
	private Objective.drugs drugs1 = new Objective.drugs();
	private JButton button_update;
	private JTextField textField;
	private JTextField textField_1;
	Objective.getin getin1 = new Objective.getin();

	/**
	 * Create the application.
	 */
	public ManageAddOldView() {
		initialize();
	}

	private void update() {

		drugsDao drugsDAO = (drugsDao) BaseDao.getAbilityDAO(Objective.DAO.drugs);
		try {
			drugs1 = drugsDAO.queryById(Integer.parseInt(textField_id.getText()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		drugs1.setMinstock(Integer.parseInt(textField_number.getText()) + drugs1.getMiinstock());
		drugsDAO.update(drugs1);

		getindao getindao = (Dao.getindao) BaseDao.getAbilityDAO(Objective.DAO.getin);
		getin1.setBuyid(Integer.parseInt(textField.getText()));
		getin1.setDate(textField_1.getText());
		getin1.setNumber(Double.parseDouble(textField_number.getText()));
		getin1.setDrugbid(drugs1.getBid());
		getin1.setDrugname(drugs1.getName());
		getin1.setManagertype("2");
		getin1.setDrugid(Integer.parseInt(textField_id.getText()));
		getindao.add(getin1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5DF2\u6709\u836F\u54C1\u5165\u5E93");
		frame.setVisible(true);
		frame.setBounds(100, 100, 631, 412);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label_1 = new JLabel("  \u836F\u54C1\u7F16\u53F7");
		label_1.setForeground(Color.MAGENTA);
		label_1.setFont(new Font("楷体", Font.PLAIN, 17));
		label_1.setBounds(45, 139, 87, 15);
		frame.getContentPane().add(label_1);

		textField_id = new JTextField();
		textField_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					update();
				}
			}
		});
		textField_id.setColumns(10);
		textField_id.setBackground(SystemColor.activeCaption);
		textField_id.setBounds(142, 137, 78, 21);
		frame.getContentPane().add(textField_id);

		JLabel label = new JLabel("  \u6570\u91CF");
		label.setForeground(Color.MAGENTA);
		label.setFont(new Font("楷体", Font.PLAIN, 17));
		label.setBounds(55, 223, 60, 15);
		frame.getContentPane().add(label);

		textField_number = new JTextField();
		textField_number.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					update();
				}
			}
		});
		textField_number.setColumns(10);
		textField_number.setBackground(SystemColor.activeCaption);
		textField_number.setBounds(142, 221, 78, 21);
		frame.getContentPane().add(textField_number);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(ManageAddOldView.class.getResource("/img/logo.jpg")));
		lblNewLabel.setBounds(512, 10, 93, 70);
		frame.getContentPane().add(lblNewLabel);

		button_ = new JButton("\u53D6\u6D88\u5165\u5E93");
		button_.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new manageView();
			}
		});
		button_.setBounds(205, 329, 93, 23);
		frame.getContentPane().add(button_);

		button_1cancel = new JButton("\u8FD4\u56DE\u4E0A\u5C42");
		button_1cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new manageView();
			}
		});
		button_1cancel.setBounds(335, 329, 93, 23);
		frame.getContentPane().add(button_1cancel);

		button_return = new JButton("\u9000\u51FA\u767B\u5F55");
		button_return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new Loginview();
			}
		});
		button_return.setBounds(499, 329, 93, 23);
		frame.getContentPane().add(button_return);

		button_update = new JButton("\u5165\u5E93");
		button_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				update();
				frame.dispose();
				new manageView();
			}
		});
		button_update.setBounds(57, 329, 93, 23);
		frame.getContentPane().add(button_update);

		JLabel label_2 = new JLabel(" \u8BA2\u5355\u7F16\u53F7");
		label_2.setForeground(Color.MAGENTA);
		label_2.setFont(new Font("楷体", Font.PLAIN, 17));
		label_2.setBounds(294, 137, 77, 15);
		frame.getContentPane().add(label_2);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					update();
				}
			}
		});
		textField.setColumns(10);
		textField.setBackground(SystemColor.activeCaption);
		textField.setBounds(381, 135, 104, 21);
		frame.getContentPane().add(textField);

		JLabel label_3 = new JLabel("\u5165\u5E93\u65F6\u95F4");
		label_3.setForeground(Color.MAGENTA);
		label_3.setFont(new Font("楷体", Font.PLAIN, 17));
		label_3.setBounds(294, 227, 77, 15);
		frame.getContentPane().add(label_3);

		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					update();
				}
			}
		});
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.activeCaption);
		textField_1.setBounds(381, 225, 104, 21);
		frame.getContentPane().add(textField_1);
	}
}
