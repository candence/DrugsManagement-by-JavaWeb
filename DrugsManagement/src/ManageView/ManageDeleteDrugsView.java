package ManageView;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import Dao.drugsDao;
import Dao.getoutdao;
import Objective.getout;
import base.BaseDao;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class ManageDeleteDrugsView {

	private JFrame frame;
	private JTextField textField_id;
	private JTextField textField_number;
	private JButton button_;
	private JButton button_1cancel;
	private JButton button_return;
	private Objective.drugs drugs1 = new Objective.drugs();
	private JButton button_update;
	private getout getout1 = new getout();
	private JLabel label_2;
	private JTextField textField_purchaseid;
	private JLabel label_3;
	private JTextField textField_data;
	private JLabel lblNewLabel_1;

	/**
	 * Create the application.
	 */
	public ManageDeleteDrugsView() {
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
			getoutdao getoutdao = (Dao.getoutdao) BaseDao.getAbilityDAO(Objective.DAO.getout);
			getout1.setId(Integer.parseInt(textField_purchaseid.getText()));
			getout1.setDate(textField_data.getText());
			getout1.setNumber(Double.parseDouble(textField_number.getText()));
			getout1.setDrugid(drugs1.getId());
			getout1.setManagetype("2");
			getout1.setDrugprice(drugs1.getPrice());
			getout1.setDrugname(drugs1.getName());
			getoutdao.add(getout1);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u836F\u54C1\u51FA\u5E93");
		frame.setVisible(true);
		frame.setBounds(100, 100, 651, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label_1 = new JLabel("  \u836F\u54C1\u7F16\u53F7");
		label_1.setForeground(Color.MAGENTA);
		label_1.setFont(new Font("楷体", Font.PLAIN, 17));
		label_1.setBounds(47, 141, 92, 15);
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
		textField_id.setBounds(149, 139, 78, 21);
		frame.getContentPane().add(textField_id);

		JLabel label = new JLabel("  \u6570\u91CF");
		label.setForeground(Color.MAGENTA);
		label.setFont(new Font("楷体", Font.PLAIN, 17));
		label.setBounds(57, 250, 60, 15);
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
		textField_number.setBounds(149, 248, 78, 21);
		frame.getContentPane().add(textField_number);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(305, 139, 54, 15);
		frame.getContentPane().add(lblNewLabel);

		button_ = new JButton("\u53D6\u6D88\u51FA\u5E93");
		button_.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new manageView();
			}
		});
		button_.setBounds(149, 345, 93, 23);
		frame.getContentPane().add(button_);

		button_1cancel = new JButton("\u8FD4\u56DE\u4E0A\u5C42");
		button_1cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new manageView();
			}
		});
		button_1cancel.setBounds(403, 345, 93, 23);
		frame.getContentPane().add(button_1cancel);

		button_return = new JButton("\u9000\u51FA\u767B\u5F55");
		button_return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new Loginview();
			}
		});
		button_return.setBounds(519, 345, 93, 23);
		frame.getContentPane().add(button_return);

		button_update = new JButton("\u51FA\u5E93");
		button_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				update();
				frame.dispose();
				new manageView();
			}
		});
		button_update.setBounds(20, 345, 93, 23);
		frame.getContentPane().add(button_update);

		label_2 = new JLabel(" \u8BA2\u5355\u7F16\u53F7");
		label_2.setForeground(Color.MAGENTA);
		label_2.setFont(new Font("楷体", Font.PLAIN, 17));
		label_2.setBounds(326, 141, 77, 15);
		frame.getContentPane().add(label_2);

		textField_purchaseid = new JTextField();
		textField_purchaseid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					update();
				}
			}
		});
		textField_purchaseid.setColumns(10);
		textField_purchaseid.setBackground(SystemColor.activeCaption);
		textField_purchaseid.setBounds(418, 139, 78, 21);
		frame.getContentPane().add(textField_purchaseid);

		label_3 = new JLabel("\u51FA\u5E93\u65F6\u95F4");
		label_3.setForeground(Color.MAGENTA);
		label_3.setFont(new Font("楷体", Font.PLAIN, 17));
		label_3.setBounds(330, 254, 77, 15);
		frame.getContentPane().add(label_3);

		textField_data = new JTextField();
		textField_data.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					update();
				}
			}
		});
		textField_data.setColumns(10);
		textField_data.setBackground(SystemColor.activeCaption);
		textField_data.setBounds(417, 252, 78, 21);
		frame.getContentPane().add(textField_data);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ManageDeleteDrugsView.class.getResource("/img/logo.jpg")));
		lblNewLabel_1.setBounds(532, 10, 93, 59);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
