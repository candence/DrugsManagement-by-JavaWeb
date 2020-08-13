package BusinessView;

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

public class BusinessAddNewView {

	private Objective.drugs drugs1 = new Objective.drugs();
	Objective.getin getin1 = new Objective.getin();
	private JFrame frame;
	private JTextField textField_id;
	private JTextField textField_name;
	private JTextField textField_jianma;
	private JTextField textField_type;
	private JTextField textField_generalname;
	private JTextField textField_norm;
	private JTextField textField_approvalnum;
	private JTextField textField_period;
	private JTextField textField_minstock;
	private JTextField textField_bid;
	private JTextField textField_price;
	private JTextField textField_products;
	private JButton getin;
	private JTextField textField_unit;
	private JTextField textField_buyid;
	private JLabel label_13;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public BusinessAddNewView() {
		initialize();
	}

	private void add() {

		drugsDao drugsDAO = (drugsDao) BaseDao.getAbilityDAO(Objective.DAO.drugs);
		drugs1.setId(Integer.parseInt(textField_id.getText()));
		drugs1.setName(textField_name.getText());
		drugs1.setJianma(textField_jianma.getText());
		drugs1.setType(textField_type.getText());
		drugs1.setApprovalnum(textField_approvalnum.getText());
		drugs1.setProducts(textField_products.getText());
		drugs1.setBid(Double.parseDouble(textField_bid.getText()));
		drugs1.setPrice(Double.parseDouble(textField_price.getText()));
		drugs1.setNorms(textField_norm.getText());
		drugs1.setPeriod(textField_period.getText());
		drugs1.setMinstock(Integer.parseInt(textField_minstock.getText()));
		drugs1.setGenralname(textField_generalname.getText());
		drugs1.setUnit(textField_unit.getText());
		drugsDAO.add(drugs1);

		getindao getindao = (Dao.getindao) BaseDao.getAbilityDAO(Objective.DAO.getin);
		getin1.setBuyid(Integer.parseInt(textField_buyid.getText()));
		getin1.setDate(textField.getText());
		getin1.setNumber(Integer.parseInt(textField_minstock.getText()));
		getin1.setDrugbid(Double.parseDouble(textField_bid.getText()));
		getin1.setDrugname(textField_name.getText());
		getin1.setManagertype("2");
		getin1.setDrugid(Integer.parseInt(textField_id.getText()));
		getindao.add(getin1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u65B0\u836F\u54C1\u5165\u5E93\u754C\u9762");
		frame.setVisible(true);
		frame.setBounds(100, 100, 610, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblId = new JLabel("  \u7F16\u53F7");
		lblId.setForeground(Color.MAGENTA);
		lblId.setFont(new Font("楷体", Font.PLAIN, 17));
		lblId.setBounds(20, 36, 60, 15);
		frame.getContentPane().add(lblId);

		textField_id = new JTextField();
		textField_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textField_id.setBackground(SystemColor.activeCaption);
		textField_id.setBounds(96, 34, 78, 21);
		frame.getContentPane().add(textField_id);

		textField_id.setColumns(10);

		JLabel label = new JLabel("  \u540D\u79F0");
		label.setForeground(Color.MAGENTA);
		label.setFont(new Font("楷体", Font.PLAIN, 17));
		label.setBounds(20, 71, 60, 15);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("  \u7B80\u79F0");
		label_1.setForeground(Color.MAGENTA);
		label_1.setFont(new Font("楷体", Font.PLAIN, 17));
		label_1.setBounds(20, 106, 72, 15);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("  \u7C7B\u578B");
		label_2.setForeground(Color.MAGENTA);
		label_2.setFont(new Font("楷体", Font.PLAIN, 17));
		label_2.setBounds(20, 141, 60, 15);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel(" \u901A\u7528\u540D");
		label_3.setForeground(Color.MAGENTA);
		label_3.setFont(new Font("楷体", Font.PLAIN, 17));
		label_3.setBounds(20, 175, 60, 15);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("  \u89C4\u683C");
		label_4.setForeground(Color.MAGENTA);
		label_4.setFont(new Font("楷体", Font.PLAIN, 17));
		label_4.setBounds(20, 215, 60, 15);
		frame.getContentPane().add(label_4);

		textField_name = new JTextField();
		textField_name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textField_name.setColumns(10);
		textField_name.setBackground(SystemColor.activeCaption);
		textField_name.setBounds(96, 67, 78, 21);
		frame.getContentPane().add(textField_name);

		textField_jianma = new JTextField();
		textField_jianma.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textField_jianma.setColumns(10);
		textField_jianma.setBackground(SystemColor.activeCaption);
		textField_jianma.setBounds(96, 104, 78, 21);
		frame.getContentPane().add(textField_jianma);

		textField_type = new JTextField();
		textField_type.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textField_type.setColumns(10);
		textField_type.setBackground(SystemColor.activeCaption);
		textField_type.setBounds(96, 139, 78, 21);
		frame.getContentPane().add(textField_type);

		textField_generalname = new JTextField();
		textField_generalname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textField_unit = new JTextField();
		textField_unit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textField_unit.setColumns(10);
		textField_unit.setBackground(SystemColor.activeCaption);
		textField_unit.setBounds(96, 250, 78, 21);
		frame.getContentPane().add(textField_unit);

		textField_generalname.setColumns(10);
		textField_generalname.setBackground(SystemColor.activeCaption);
		textField_generalname.setBounds(96, 173, 78, 21);
		frame.getContentPane().add(textField_generalname);

		textField_norm = new JTextField();
		textField_norm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textField_norm.setColumns(10);
		textField_norm.setBackground(SystemColor.activeCaption);
		textField_norm.setBounds(96, 213, 78, 21);
		frame.getContentPane().add(textField_norm);

		JLabel label_5 = new JLabel("  \u6279\u51C6\u6587\u53F7");
		label_5.setForeground(Color.MAGENTA);
		label_5.setFont(new Font("楷体", Font.PLAIN, 17));
		label_5.setBounds(266, 80, 86, 15);
		frame.getContentPane().add(label_5);

		JLabel label_6 = new JLabel("  \u4FDD\u8D28\u671F");
		label_6.setForeground(Color.MAGENTA);
		label_6.setFont(new Font("楷体", Font.PLAIN, 17));
		label_6.setBounds(266, 115, 86, 15);
		frame.getContentPane().add(label_6);

		JLabel label_7 = new JLabel(" \u6570\u91CF");
		label_7.setForeground(Color.MAGENTA);
		label_7.setFont(new Font("楷体", Font.PLAIN, 17));
		label_7.setBounds(285, 150, 55, 15);
		frame.getContentPane().add(label_7);

		JLabel label_8 = new JLabel(" \u8FDB\u4EF7");
		label_8.setForeground(Color.MAGENTA);
		label_8.setFont(new Font("楷体", Font.PLAIN, 17));
		label_8.setBounds(285, 185, 60, 15);
		frame.getContentPane().add(label_8);

		JLabel label_9 = new JLabel(" \u552E\u4EF7");
		label_9.setForeground(Color.MAGENTA);
		label_9.setFont(new Font("楷体", Font.PLAIN, 17));
		label_9.setBounds(285, 219, 60, 15);
		frame.getContentPane().add(label_9);

		JLabel label_10 = new JLabel("  \u751F\u4EA7\u5382\u5BB6");
		label_10.setForeground(Color.MAGENTA);
		label_10.setFont(new Font("楷体", Font.PLAIN, 17));
		label_10.setBounds(266, 259, 86, 15);
		frame.getContentPane().add(label_10);

		textField_approvalnum = new JTextField();
		textField_approvalnum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textField_approvalnum.setColumns(10);
		textField_approvalnum.setBackground(SystemColor.activeCaption);
		textField_approvalnum.setBounds(362, 80, 78, 21);
		frame.getContentPane().add(textField_approvalnum);

		textField_period = new JTextField();
		textField_period.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textField_period.setColumns(10);
		textField_period.setBackground(SystemColor.activeCaption);
		textField_period.setBounds(362, 113, 78, 21);
		frame.getContentPane().add(textField_period);

		textField_minstock = new JTextField();
		textField_minstock.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textField_minstock.setColumns(10);
		textField_minstock.setBackground(SystemColor.activeCaption);
		textField_minstock.setBounds(362, 148, 78, 21);
		frame.getContentPane().add(textField_minstock);

		textField_bid = new JTextField();
		textField_bid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textField_bid.setColumns(10);
		textField_bid.setBackground(SystemColor.activeCaption);
		textField_bid.setBounds(362, 183, 78, 21);
		frame.getContentPane().add(textField_bid);

		textField_price = new JTextField();
		textField_price.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textField_price.setColumns(10);
		textField_price.setBackground(SystemColor.activeCaption);
		textField_price.setBounds(362, 217, 78, 21);
		frame.getContentPane().add(textField_price);

		textField_products = new JTextField();
		textField_products.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textField_products.setColumns(10);
		textField_products.setBackground(SystemColor.activeCaption);
		textField_products.setBounds(362, 257, 78, 21);
		frame.getContentPane().add(textField_products);

		JButton button_1 = new JButton("\u53D6\u6D88\u5165\u5E93");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new BusinessView();
			}
		});
		button_1.setBounds(478, 380, 93, 23);
		frame.getContentPane().add(button_1);

		getin = new JButton("\u6DFB\u52A0");
		getin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add();
				frame.dispose();
				new BusinessView();

			}

		});
		getin.setBounds(34, 381, 72, 21);
		frame.getContentPane().add(getin);

		JLabel label_11 = new JLabel("  \u5355\u4F4D");
		label_11.setForeground(Color.MAGENTA);
		label_11.setFont(new Font("楷体", Font.PLAIN, 17));
		label_11.setBounds(20, 252, 60, 15);
		frame.getContentPane().add(label_11);

		JLabel label_12 = new JLabel("  \u8BA2\u5355\u7F16\u53F7");
		label_12.setForeground(Color.MAGENTA);
		label_12.setFont(new Font("楷体", Font.PLAIN, 17));
		label_12.setBounds(266, 296, 86, 15);
		frame.getContentPane().add(label_12);

		textField_buyid = new JTextField();
		textField_buyid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textField_buyid.setColumns(10);
		textField_buyid.setBackground(SystemColor.activeCaption);
		textField_buyid.setBounds(362, 294, 78, 21);
		frame.getContentPane().add(textField_buyid);

		label_13 = new JLabel(" \u5165\u5E93\u65E5\u671F");
		label_13.setForeground(Color.MAGENTA);
		label_13.setFont(new Font("楷体", Font.PLAIN, 17));
		label_13.setBounds(10, 292, 78, 15);
		frame.getContentPane().add(label_13);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					add();
				}
			}
		});
		textField.setColumns(10);
		textField.setBackground(SystemColor.activeCaption);
		textField.setBounds(96, 290, 78, 21);
		frame.getContentPane().add(textField);

	}
}
