/**==============================================================================
 * Project Name : Score Calculator
 * Published by : YOOK DONGHYUN (aomorikaitou93@gmail.com)
 * ==============================================================================
 * # This program provides you to below features
 * - calculate score for single & multiple subject (ver 1.0)
 * - provide result for single & multiple subject, whether pass or fail (ver 1.0)
 * ===============================================================================
 * Version Control
 * -------------------------------------------------------------------------------
 * 2019-07-09 : create Score Calculator ver 1.0
 * ==============================================================================*/

package calc;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Color;

public class MainGUI extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel pnlSingle;
	private JPanel pnlMultiple;
	private JLabel lblNum;
	private JTextField txtNum;
	private JLabel lblTot;
	private JLabel lblForScore;
	private JTextField txtScore;
	private JButton btnCalculate;
	private JButton btnResetTxt;
	private JLabel lblSub1;
	private JLabel lblSub2;
	private JLabel lblSub3;
	private JLabel lblSub4;
	private JLabel lblSub5;
	private JButton btnCalc;
	private JButton btnReset;
	private JLabel lblScore;
	private JLabel lblTot1;
	private JLabel lblTot2;
	private JLabel lblTot3;
	private JLabel lblTot4;
	private JLabel lblTot5;
	private JLabel lblResult1;
	private JLabel lblResult2;
	private JLabel lblResult3;
	private JLabel lblResult4;
	private JLabel lblResult5;
	private JLabel lblScore1;
	private JLabel lblScore2;
	private JLabel lblScore3;
	private JLabel lblScore4;
	private JLabel lblScore5;
	private JTextField txtSub1;
	private JTextField txtSub2;
	private JTextField txtSub3;
	private JTextField txtSub4;
	private JTextField txtSub5;
	
	private boolean flag = false; // 과락 플래그
	private JLabel lblResult;
	
	/** Launch the application */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainGUI window = new MainGUI();
					window.frame.setVisible(true);
				} 
				catch (Exception e) { e.printStackTrace(); }
			}
		});
	}

	/** Create the application */
	public MainGUI() { initialize(); }

	/** Initialize the contents of the frame */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("물류관리사 점수계산기");
		frame.setBounds(100, 100, 467, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 673, 480);
		frame.getContentPane().add(tabbedPane);
		
		pnlSingle = new JPanel();
		tabbedPane.addTab("한과목 계산", null, pnlSingle, null);
		pnlSingle.setLayout(null);
		
		lblNum = new JLabel("맞은 개수");
		lblNum.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNum.setBounds(67, 56, 80, 26);
		pnlSingle.add(lblNum);
		
		txtNum = new JTextField();
		txtNum.setBounds(161, 58, 62, 27);
		pnlSingle.add(txtNum);
		txtNum.setColumns(10);
		
		lblTot = new JLabel("/ 40개");
		lblTot.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblTot.setBounds(237, 60, 62, 18);
		pnlSingle.add(lblTot);
		
		lblForScore = new JLabel("점수");
		lblForScore.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblForScore.setBounds(67, 132, 62, 18);
		pnlSingle.add(lblForScore);
		
		txtScore = new JTextField();
		txtScore.setBackground(Color.WHITE);
		txtScore.setEditable(false);
		txtScore.setBounds(156, 130, 67, 27);
		pnlSingle.add(txtScore);
		txtScore.setColumns(10);
		
		btnCalculate = new JButton("계산");
		btnCalculate.addActionListener(this);
		btnCalculate.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnCalculate.setBounds(89, 191, 105, 27);
		pnlSingle.add(btnCalculate);
		
		btnResetTxt = new JButton("초기화");
		btnResetTxt.addActionListener(this);
		btnResetTxt.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnResetTxt.setBounds(208, 191, 105, 27);
		pnlSingle.add(btnResetTxt);
		
		lblScore = new JLabel("점");
		lblScore.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblScore.setBounds(231, 129, 29, 25);
		pnlSingle.add(lblScore);
		
		lblResult = new JLabel("결과");
		lblResult.setBounds(288, 135, 38, 16);
		pnlSingle.add(lblResult);
		lblResult.setVisible(false);
		
		pnlMultiple = new JPanel();
		tabbedPane.addTab("전체과목 계산", null, pnlMultiple, null);
		pnlMultiple.setLayout(null);
		
		btnCalc = new JButton("계산");
		btnCalc.addActionListener(this);
		btnCalc.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnCalc.setBounds(96, 234, 105, 27);
		pnlMultiple.add(btnCalc);
		
		btnReset = new JButton("초기화");
		btnReset.addActionListener(this);
		btnReset.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnReset.setBounds(228, 234, 105, 27);
		pnlMultiple.add(btnReset);
		
		lblSub1 = new JLabel("물류관리론");
		lblSub1.setBounds(69, 31, 80, 22);
		pnlMultiple.add(lblSub1);
		lblSub1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		lblSub2 = new JLabel("화물운송론");
		lblSub2.setBounds(69, 65, 80, 22);
		pnlMultiple.add(lblSub2);
		lblSub2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		lblSub3 = new JLabel("국제물류론");
		lblSub3.setBounds(69, 99, 80, 22);
		pnlMultiple.add(lblSub3);
		lblSub3.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		lblSub4 = new JLabel("보관하역론");
		lblSub4.setBounds(69, 131, 80, 22);
		pnlMultiple.add(lblSub4);
		lblSub4.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		lblSub5 = new JLabel("물류관련법규");
		lblSub5.setBounds(53, 165, 96, 22);
		pnlMultiple.add(lblSub5);
		lblSub5.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		txtSub1 = new JTextField();
		txtSub1.setBounds(163, 33, 66, 22);
		pnlMultiple.add(txtSub1);
		txtSub1.setMaximumSize(new Dimension(10, 24));
		txtSub1.setPreferredSize(new Dimension(5, 24));
		txtSub1.setColumns(5);
		
		txtSub2 = new JTextField();
		txtSub2.setBounds(163, 67, 66, 22);
		pnlMultiple.add(txtSub2);
		txtSub2.setColumns(10);
		
		txtSub3 = new JTextField();
		txtSub3.setBounds(163, 101, 66, 22);
		pnlMultiple.add(txtSub3);
		txtSub3.setColumns(10);
		
		txtSub4 = new JTextField();
		txtSub4.setBounds(163, 135, 66, 22);
		pnlMultiple.add(txtSub4);
		txtSub4.setColumns(10);
		
		txtSub5 = new JTextField();
		txtSub5.setBounds(163, 167, 66, 22);
		pnlMultiple.add(txtSub5);
		txtSub5.setColumns(10);
		
		lblTot1 = new JLabel("/ 40개");
		lblTot1.setBounds(239, 31, 47, 22);
		pnlMultiple.add(lblTot1);
		lblTot1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		lblTot2 = new JLabel("/ 40개");
		lblTot2.setBounds(239, 65, 47, 22);
		pnlMultiple.add(lblTot2);
		lblTot2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		lblTot3 = new JLabel("/ 40개");
		lblTot3.setBounds(239, 99, 47, 22);
		pnlMultiple.add(lblTot3);
		lblTot3.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		lblTot4 = new JLabel("/ 40개");
		lblTot4.setBounds(239, 133, 47, 22);
		pnlMultiple.add(lblTot4);
		lblTot4.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		lblTot5 = new JLabel("/ 40개");
		lblTot5.setBounds(239, 165, 47, 22);
		pnlMultiple.add(lblTot5);
		lblTot5.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		lblScore1 = new JLabel("점수");
		lblScore1.setBounds(300, 35, 66, 22);
		pnlMultiple.add(lblScore1);
		
		lblScore2 = new JLabel("점수");
		lblScore2.setBounds(300, 69, 66, 18);
		pnlMultiple.add(lblScore2);
		
		lblScore3 = new JLabel("점수");
		lblScore3.setBounds(300, 103, 66, 18);
		pnlMultiple.add(lblScore3);
		
		lblScore4 = new JLabel("점수");
		lblScore4.setBounds(300, 139, 66, 18);
		pnlMultiple.add(lblScore4);
		
		lblScore5 = new JLabel("점수");
		lblScore5.setBounds(300, 171, 66, 16);
		pnlMultiple.add(lblScore5);
		
		lblResult1 = new JLabel("결과");
		lblResult1.setBounds(366, 35, 47, 18);
		pnlMultiple.add(lblResult1);
		
		lblResult2 = new JLabel("결과");
		lblResult2.setBounds(366, 69, 47, 18);
		pnlMultiple.add(lblResult2);
		
		lblResult3 = new JLabel("결과");
		lblResult3.setBounds(366, 103, 47, 18);
		pnlMultiple.add(lblResult3);
		
		lblResult4 = new JLabel("결과");
		lblResult4.setBounds(366, 137, 47, 18);
		pnlMultiple.add(lblResult4);
		
		lblResult5 = new JLabel("결과");
		lblResult5.setBounds(366, 171, 47, 18);
		pnlMultiple.add(lblResult5);
		
		lblResult5.setVisible(false);
		lblResult4.setVisible(false);
		lblResult3.setVisible(false);
		lblResult2.setVisible(false);
		lblResult1.setVisible(false);
		
		lblScore5.setVisible(false);
		lblScore4.setVisible(false);
		lblScore3.setVisible(false);
		lblScore2.setVisible(false);
		lblScore1.setVisible(false);
	}
	
	public void getScore(double sc, JLabel lbl)
	{
		lbl.setText(Double.toString(sc) + "점");
		lbl.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lbl.setVisible(true);
	}
	
	public void getResult(double sc, JLabel lbl)
	{
		flag = false;
		if(sc < 40)
		{
			lbl.setText("과락");
			lbl.setForeground(Color.RED);
			flag = true;
		}
		else
		{
			lbl.setText("통과");
			lbl.setForeground(Color.BLUE);
		}
		lbl.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lbl.setVisible(true);
	}
	
	public void getTestResult(ArrayList<Double> sc)
	{
		double sum = 0.0;
		
		for(double s : sc)
			sum += s;
		
		double avg = sum / 5.0;
		
		if(avg < 60)
		{
			if(flag)
				JOptionPane.showMessageDialog(MainGUI.this, "   불합격입니다!\n" + "   사유: 과락\n" + "   전체평균: " + avg , "시험 결과", JOptionPane.PLAIN_MESSAGE);
			else
				JOptionPane.showMessageDialog(MainGUI.this, "   불합격입니다!\n" + "   사유: 평균미달\n" + "   전체평균: " + avg , "시험 결과", JOptionPane.PLAIN_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(MainGUI.this, "   합격입니다!\n" + "   전체평균: " + avg , "시험 결과", JOptionPane.PLAIN_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnReset)
		{
			flag = false;
			
			txtSub1.setText("");
			txtSub2.setText("");
			txtSub3.setText("");
			txtSub4.setText("");
			txtSub5.setText("");
			
			lblScore1.setVisible(false);
			lblScore2.setVisible(false);
			lblScore3.setVisible(false);
			lblScore4.setVisible(false);
			lblScore5.setVisible(false);
			
			lblResult1.setVisible(false);
			lblResult2.setVisible(false);
			lblResult3.setVisible(false);
			lblResult4.setVisible(false);
			lblResult5.setVisible(false);
		}
		
		if(e.getSource() == btnCalc)
		{
			flag = false;
			ArrayList<Integer> sub = new ArrayList<>();
			sub.add(Integer.parseInt(txtSub1.getText()));
			sub.add(Integer.parseInt(txtSub2.getText()));
			sub.add(Integer.parseInt(txtSub3.getText()));
			sub.add(Integer.parseInt(txtSub4.getText()));
			sub.add(Integer.parseInt(txtSub5.getText()));
			
			try 
			{
				// for error-checking
				for(int i = 0; i < 5; i++)
					if(sub.get(i) < 0 || sub.get(i) > 40)
						throw new NumberOutOfBoundException("0부터 40 사이의 값을 입력해주십시오!");
				
				// calculate score
				ArrayList<Double> score = new ArrayList<>();
				for(int i = 0; i < 5; i++)
					score.add(sub.get(i) * 2.5);
				
				getScore(score.get(0), lblScore1);
				getScore(score.get(1), lblScore2);
				getScore(score.get(2), lblScore3);
				getScore(score.get(3), lblScore4);
				getScore(score.get(4), lblScore5);
				
				getResult(score.get(0), lblResult1);
				getResult(score.get(1), lblResult2);
				getResult(score.get(2), lblResult3);
				getResult(score.get(3), lblResult4);
				getResult(score.get(4), lblResult5);
			
				getTestResult(score);
			}
			catch(NumberOutOfBoundException ex)
			{
				JOptionPane.showMessageDialog(null, ex.getMessage(), "입력오류", JOptionPane.ERROR_MESSAGE);
				txtSub1.setText("");
				txtSub2.setText("");
				txtSub3.setText("");
				txtSub4.setText("");
				txtSub5.setText("");
			}
		}
		
		if(e.getSource() == btnCalculate)
		{
			flag = false;
			lblResult.setVisible(false);
			try 
			{
				if(Integer.parseInt(txtNum.getText()) < 0 || Integer.parseInt(txtNum.getText()) > 40)
					throw new NumberOutOfBoundException("0부터 40 사이의 값을 입력해주십시오!");
				
				double score = Integer.parseInt(txtNum.getText()) * 2.5;
				txtScore.setText(Double.toString(score));
				getResult(score, lblResult);
			}
			catch(NumberOutOfBoundException ex)
			{
				JOptionPane.showMessageDialog(null, ex.getMessage(), "입력오류", JOptionPane.ERROR_MESSAGE);
				txtNum.setText("");
				txtScore.setText("");
			}
		}
		
		if(e.getSource() == btnResetTxt)
		{
			flag = false;
			txtNum.setText("");
			txtScore.setText("");
			lblResult.setVisible(false);
		}
	}
}
