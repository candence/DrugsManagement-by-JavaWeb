package BusinessView;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import Dao.drugsDao;
import ManageView.Loginview;

import base.BaseDao;

import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class BusinessDeleteDrugsView {

	private JFrame frame;
	private JTextField textField_id;
	private JTextField textField_number;
	private JButton button_;
	private JButton button_1cancel;
	private JButton button_return;
	private Objective.drugs drugs1 = new Objective.drugs();
	private JButton button_update;

	/**
	 * Create the application.
	 */
	public BusinessDeleteDrugsView() {
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
		if (drugs1.getMiinstock() - Integer.parseInt(textField_number.getText()) > 0) {
			drugs1.setMinstock(drugs1.getMiinstock() - Integer.parseInt(textField_number.getText()));
			drugsDAO.update(drugs1);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u836F\u54C1\u51FA\u5E93");
		frame.setVisible(true);
		frame.setBounds(100, 100, 630, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label_1 = new JLabel("  \u7F16\u53F7");
		label_1.setForeground(Color.MAGENTA);
		label_1.setFont(new Font("¿¬Ìå", Font.PLAIN, 17));
		label_1.setBounds(68, 208, 60, 15);
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
		textField_id.setBounds(144, 206, 78, 21);
		frame.getContentPane().add(textField_id);

		JLabel label = new JLabel("  \u6570\u91CF");
		label.setForeground(Color.MAGENTA);
		label.setFont(new Font("¿¬Ìå", Font.PLAIN, 17));
		label.setBounds(272, 212, 60, 15);
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
		textField_number.setBounds(348, 210, 78, 21);
		frame.getContentPane().add(textField_number);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(511, 10, 93, 83);
		frame.getContentPane().add(lblNewLabel);

		button_ = new JButton("\u53D6\u6D88\u51FA\u5E93");
		button_.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new BusinessView();
			}
		});
		button_.setBounds(143, 359, 93, 23);
		frame.getContentPane().add(button_);

		button_1cancel = new JButton("\u8FD4\u56DE\u4E0A\u5C42");
		button_1cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new BusinessView();
			}
		});
		button_1cancel.setBounds(362, 359, 93, 23);
		frame.getContentPane().add(button_1cancel);

		button_return = new JButton("\u9000\u51FA\u767B\u5F55");
		button_return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new Loginview();
			}
		});
		button_return.setBounds(487, 359, 93, 23);
		frame.getContentPane().add(button_return);

		button_update = new JButton("\u51FA\u5E93");
		button_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				update();
				frame.dispose();
				new BusinessView();
			}
		});
		button_update.setBounds(10, 359, 93, 23);
		frame.getContentPane().add(button_update);
		lblNewLabel.setIcon(new ImageIcon(BusinessDeleteDrugsView.class.getResource("/img/logo.jpg")));
	}

}
