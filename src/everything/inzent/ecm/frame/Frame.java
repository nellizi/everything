package everything.inzent.ecm.frame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import everything.inzent.ecm.file.MyFile;


public class Frame extends JFrame {

	/*
	 * 1. new Frame() 하면 상단 패널만 존재하는 frame 생성하기 
	 * 2. 상단 패널에 디렉토리 입력 텍스트필드 추가 
	 * 3. 검색버튼추가
	 * 4. 검색버튼 추가시 하단 패널 띄우기 
	 *  4-1. 하단 패널 띄울 때 2번의 텍스트필드 값 매개변수로 넘기기 
	 * 5. 매개변수로 받은 값파일 불러오는 매서드 매개변수로 넘기기
	 */

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPanel tablePanel;
	private String dirPath ="";
	private MyFile file;

	public Frame() {
		super("EveryThing_By_Liz");
		
		file = new MyFile();
//		frame = new JFrame("EveryThing_By_Liz");
		super.setSize(881, 613);

		JPanel panelTop = new JPanel();
		panelTop.setBounds(6, 500, 990, 59);
		SpringLayout sl_panelTop = new SpringLayout();
		panelTop.setLayout(sl_panelTop);

		JTextField address = new JTextField(20);
		sl_panelTop.putConstraint(SpringLayout.NORTH, address, 10, SpringLayout.NORTH, panelTop);
		sl_panelTop.putConstraint(SpringLayout.WEST, address, 31, SpringLayout.WEST, panelTop);
		panelTop.add(address);
		JButton btn1 = new JButton("검색");
		sl_panelTop.putConstraint(SpringLayout.NORTH, btn1, 9, SpringLayout.NORTH, panelTop);
		sl_panelTop.putConstraint(SpringLayout.EAST, address, -6, SpringLayout.WEST, btn1);
		sl_panelTop.putConstraint(SpringLayout.EAST, btn1, -32, SpringLayout.EAST, panelTop);
		panelTop.add(btn1);
		getContentPane().add(panelTop);

		
		JPanel bottomPanel = new JPanel();
		sl_panelTop.putConstraint(SpringLayout.NORTH, bottomPanel, -522, SpringLayout.SOUTH, panelTop);
		sl_panelTop.putConstraint(SpringLayout.WEST, bottomPanel, 10, SpringLayout.WEST, panelTop);
		sl_panelTop.putConstraint(SpringLayout.SOUTH, bottomPanel, -10, SpringLayout.SOUTH, panelTop);
		sl_panelTop.putConstraint(SpringLayout.EAST, bottomPanel, 855, SpringLayout.WEST, panelTop);
		panelTop.add(bottomPanel);
		SpringLayout sl_panel = new SpringLayout();
		bottomPanel.setLayout(sl_panel);
		bottomPanel.setVisible(false);

		
		textField_2 = new JTextField(20);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_2, 6, SpringLayout.NORTH, bottomPanel);
		sl_panel.putConstraint(SpringLayout.WEST, textField_2, 21, SpringLayout.WEST, bottomPanel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_2, -84, SpringLayout.EAST, bottomPanel);
		bottomPanel.add(textField_2);

		JButton btn1_1 = new JButton("검색");
		sl_panel.putConstraint(SpringLayout.NORTH, btn1_1, -1, SpringLayout.NORTH, textField_2);
		sl_panel.putConstraint(SpringLayout.WEST, btn1_1, 6, SpringLayout.EAST, textField_2);
		bottomPanel.add(btn1_1);
		
		

		tablePanel = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, tablePanel, 5, SpringLayout.SOUTH, btn1_1);
		sl_panel.putConstraint(SpringLayout.WEST, tablePanel, 21, SpringLayout.WEST, bottomPanel);
		sl_panel.putConstraint(SpringLayout.SOUTH, tablePanel, 474, SpringLayout.SOUTH, btn1_1);
		sl_panel.putConstraint(SpringLayout.EAST, tablePanel, 823, SpringLayout.WEST, bottomPanel);
		bottomPanel.add(tablePanel);

		JPanel panelbottom = new JPanel();
		panelbottom.setBounds(200, 500, 990, 59);

		
		JTextField filePath = new JTextField(20);
		panelbottom.add(filePath);
		JButton btn2 = new JButton("검색2");
		panelbottom.add(btn2);
		
		

		Dimension frameSize = getSize();
		// 해상도 값
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2); // 화면 중앙에 띄우기
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		
		showTable(dirPath);

		// 이벤트? 실행되는 시점을 알려주기 위함
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dirPath = address.getText(); 
				bottomPanel.setVisible(true);
			}
		});

	}

	public void showTable(String address) {
		
		String[][] data = file.getList(address);

		String[] header = new String[] { "이름", "경로", "크기", "수정한 날짜" };

		DefaultTableModel tableModel = new DefaultTableModel(data, header);
		JTable table = new JTable(tableModel) { // 셀에서 편집할 수 없게
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table.setBounds(50, 50, 975, 255);

		// 셀 값 가운데 정렬
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
		JLabel headerLabel = (JLabel) rendererFromHeader;
		headerLabel.setHorizontalAlignment(JLabel.CENTER);

		// 컬럼 크기
		TableColumnModel colModel = table.getColumnModel();
		colModel.getColumn(0).setPreferredWidth(30);
		colModel.getColumn(1).setPreferredWidth(300);
		colModel.getColumn(2).setPreferredWidth(15);
		colModel.getColumn(3).setPreferredWidth(100);

		table.getTableHeader().setFont(new Font("NanumGothic", Font.BOLD, 13)); // header 폰트 설정
		table.getTableHeader().setPreferredSize(new Dimension(100, 30)); // header 넓이, 높이
		table.setFont(new Font("NanumGothic", Font.PLAIN, 13)); // 셀 폰트, 크기
		table.setRowHeight(30);

		// 테이블에 스크롤바 추가
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(975, 645));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0)); // padding(상, 좌, 하, 우)
		tablePanel.add(scrollPane); // JScrollPane을 panelTop에 바로 올리면 안 보임. 전용 tablePanel에 올려야 보임

	}
	
}
