package everything.inzent.ecm.frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SpringLayout;

public class Frame extends JFrame {

	/*
	 * 1. new Frame() 하면 상단 패널만 존재하는 frame 생성하기 
	 * 2. 상단 패널에 디렉토리 입력 텍스트필드 추가 
	 * 3. 검색버튼 추가 
	 * 4. 검색버튼 추가시 하단 패널 띄우기 
	 * 4-1. 하단 패널 띄울 때 2번의 텍스트필드 값 매개변수로 넘기기 
	 * 5. 매개변수로 받은 값 파일 불러오는 매서드 매개변수로 넘기기
	 */

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public Frame() {
		
		super("EveryThing_By_Liz");
//		frame = new JFrame("EveryThing_By_Liz");
		super.setSize(881, 613);
		
		
        JPanel panelTop = new JPanel();
        panelTop.setBounds(6, 500, 990, 59);
        SpringLayout sl_panelTop = new SpringLayout();
        panelTop.setLayout(sl_panelTop);
        
        JTextField address=new JTextField(20);
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
        
        JPanel tablePanel = new JPanel();
        sl_panel.putConstraint(SpringLayout.NORTH, tablePanel, 5, SpringLayout.SOUTH, btn1_1);
        sl_panel.putConstraint(SpringLayout.WEST, tablePanel, 21, SpringLayout.WEST, bottomPanel);
        sl_panel.putConstraint(SpringLayout.SOUTH, tablePanel, 474, SpringLayout.SOUTH, btn1_1);
        sl_panel.putConstraint(SpringLayout.EAST, tablePanel, 823, SpringLayout.WEST, bottomPanel);
        bottomPanel.add(tablePanel);
        
        
        JPanel panelbottom = new JPanel();
        panelbottom.setBounds(200, 500, 990, 59);
        
        JTextField filePath=new JTextField(20);
        panelbottom.add(filePath);
        JButton btn2 = new JButton("검색2");
        panelbottom.add(btn2);
        
        
        
        
        
        
 
        Dimension frameSize = getSize();
        //해상도 값 
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2); //화면 중앙에 띄우기
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
 
        
        //이벤트? 실행되는 시점을 알려주기 위함
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bottomPanel.setVisible(true); // 창 안보이게 하기 
            }
        });
		
		
//		frame = new JFrame("EveryThing_By_Liz");
//		frame.setSize(1024, 768);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 누르면 프로그램 종료
//		frame.setLocationRelativeTo(null); // 프레임을 화면 중앙에 배치
//		frame.setResizable(false); // 프레임 크기를 변경하지 못하도록 설정
//		frame.getContentPane().setLayout(null); // 프레임에 추가되는 컴포넌트 레이아웃 -> Absolute
//
//		JPanel panelTop = new JPanel(); // 상단 패널
//		panelTop.setBounds(6, 6, 990, 59); // 패널 위치와 크기 -> (x좌표, y좌표, 넓이, 높이)
//		panelTop.setLayout(null); // 상단 패널에 추가되는 컴포넌트 레이아웃 -> Absolute *****
//		
//		
///*panelTop*/
//		textField_1 = new JTextField(20);
//		textField_1.setBounds(34, 10, 856, 21);
//		panelTop.add(textField_1);
//		
//		JButton btn1_1_1 = new JButton("검색");
//		btn1_1_1.setBounds(902, 9, 57, 23);
//		panelTop.add(btn1_1_1);
//		
///*panelTop*/
//
//		frame.getContentPane().add(panelTop); // 프레임에 추가하기
//		panelTop.setVisible(true); // 패널 보이기
//		
//		
//		
//		
//		
//
//		JPanel panelBottom = new JPanel(); // 하단 패널
//		panelBottom.setBounds(6, 75, 990, 651); // 패널 위치와 크기 -> (x좌표, y좌표, 넓이, 높이)
//		panelBottom.setLayout(null); // 하단 패널에 추가되는 컴포넌트 레이아웃 -> Absolute
//		frame.getContentPane().add(panelBottom); // 프레임에 추가하기
//
//		JPanel tablePanel = new JPanel();
//		tablePanel.setBounds(12, 41, 972, 578);
//		panelBottom.add(tablePanel);
//
//		textField = new JTextField(20);
//		textField.setBounds(36, 10, 856, 21);
//		panelBottom.add(textField);
//
//		JButton btn1_1 = new JButton("검색");
//		btn1_1.setBounds(900, 9, 57, 23);
//		panelBottom.add(btn1_1);
//		panelBottom.setVisible(false); // 하단 패널 가리기
//
//
//		Dimension frameSize = getSize();
//		// 해상도 값
//		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
//		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2); // 화면 중앙에 띄우기
//		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		setVisible(true);
		

	}
	
	
	
	
}
