package BusinessView;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;

import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.getindao;
import Dao.getoutdao;
import ManageView.Loginview;
import ManageView.ManageAddOldView;

public class BusinessGetOutShowView {

	private JFrame frame;

	private JTextField textField;
	public static int currpageNum = 1;
	public final int MAXPAGENUM = 99;
	private JTable table;

	/**
	 * Create the application.
	 */
	public BusinessGetOutShowView() {
		initialize();
	}

	private void initJtable() {
		table = new JTable();
		String[][] result = getoutdao.getInstance().list(currpageNum);
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("订单编号");
		model.addColumn("药品编号");
		model.addColumn("药品名称");
		model.addColumn("数量");
		model.addColumn("药品售价");
		model.addColumn("处理类型");
		model.addColumn("日期");

		for (int i = 0; i < result.length; i++) {
			model.addRow(result[i]);
		}
		table = new JTable(model);
		table.setBounds(10, 10, 975, 240);
		frame.getContentPane().add(table);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u51FA\u5E93\u8868\u5355");
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
				table.updateUI();
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
					table.updateUI();
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
				if (currpageNum <= 99) {
					currpageNum++;
					table.updateUI();
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
				table.updateUI();
				initJtable();
				textField.setText("" + currpageNum);
			}
		});
		btnNewButton.setBounds(859, 260, 81, 23);
		frame.getContentPane().add(btnNewButton);
		JButton btnexcel = new JButton("\u5BFC\u51FAExcel");
		btnexcel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				getindao.getInstance().ReadExcelFromDb();
				new BusinessView();
			}
		});
		btnexcel.setBounds(10, 306, 94, 23);
		frame.getContentPane().add(btnexcel);

		JButton button_5 = new JButton("\u8FD4\u56DE\u4E0A\u5C42");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new BusinessView();
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

		JLabel label = new JLabel("/99\u9875");
		label.setBounds(459, 277, 67, 15);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("\u7B2C");

		label_1.setBounds(377, 277, 21, 15);
		frame.getContentPane().add(label_1);

		textField = new JTextField();

		textField.setBounds(419, 273, 30, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ManageAddOldView.class.getResource("/img/logo.jpg")));
		lblNewLabel.setBounds(396, 328, 94, 60);
		frame.getContentPane().add(lblNewLabel);

	}
}
