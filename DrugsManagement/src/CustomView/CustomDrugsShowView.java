package CustomView;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Dao.drugsDao;
import ManageView.Loginview;

public class CustomDrugsShowView {

	private JFrame frame;

	private JTextField textField;
	public static int currpageNum = 1;
	public final int MAXPAGENUM = 99;
	private JTable table;

	/**
	 * Create the application.
	 */
	public CustomDrugsShowView() {
		initialize();
	}

	private void initJtable() {

		table = new JTable();
		String[][] result = drugsDao.getInstance().list(currpageNum);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("名称");
		model.addColumn("简称");
		model.addColumn("类型");
		model.addColumn("通用名");
		model.addColumn("单位");
		model.addColumn("规格");
		model.addColumn("批准文号");
		model.addColumn("保质期");
		model.addColumn("最低库存");
		model.addColumn("进价");
		model.addColumn("售价");
		model.addColumn("生产厂家");

		for (int i = 0; i < result.length; i++) {
			model.addRow(result[i]);
		}
		table = new JTable(model);
		table.setBounds(10, 10, 975, 240);
		frame.getContentPane().add(table);
		table.updateUI();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u836F\u54C1\u4E00\u89C8");
		frame.setVisible(true);
		frame.setBounds(100, 100, 966, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		initJtable();
		JButton button = new JButton("\u9996\u9875");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currpageNum = 1;

				initJtable();
				textField.setText("" + currpageNum);
			}
		});
		button.setBounds(20, 260, 67, 23);
		frame.getContentPane().add(button);
		JButton button_1 = new JButton("\u4E0A\u4E00\u9875");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (currpageNum > 1) {
					currpageNum--;

					initJtable();
					textField.setText("" + currpageNum);
				}

			}
		});
		button_1.setBounds(229, 260, 81, 23);
		frame.getContentPane().add(button_1);
		JButton button_2 = new JButton("\u4E0B\u4E00\u9875");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (currpageNum <= MAXPAGENUM) {
					currpageNum++;
					initJtable();
					textField.setText("" + currpageNum);
				}

			}
		});
		button_2.setBounds(606, 260, 80, 23);
		frame.getContentPane().add(button_2);
		JButton btnNewButton = new JButton("\u672B\u9875");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currpageNum = MAXPAGENUM;
				initJtable();
				textField.setText("" + currpageNum);
			}
		});
		btnNewButton.setBounds(859, 260, 81, 23);
		frame.getContentPane().add(btnNewButton);

		JButton button_4 = new JButton("\u836F\u54C1\u51FA\u5E93");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button_4.setBounds(217, 306, 93, 23);
		frame.getContentPane().add(button_4);

		JButton button_5 = new JButton("\u8FD4\u56DE\u4E0A\u5C42");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new CustomVew();
			}
		});
		button_5.setBounds(593, 309, 93, 23);
		frame.getContentPane().add(button_5);

		JButton button_6 = new JButton("\u8FD4\u56DE\u767B\u5F55\u754C\u9762");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new Loginview();
			}
		});
		button_6.setBounds(820, 309, 120, 23);
		frame.getContentPane().add(button_6);

		JLabel label = new JLabel("   /99\u9875");
		label.setBounds(459, 277, 67, 15);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("\u7B2C");

		label_1.setBounds(377, 277, 21, 15);
		frame.getContentPane().add(label_1);

		textField = new JTextField();

		textField.setBounds(419, 273, 30, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

	}
}
