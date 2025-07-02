/**
 * Program Name: StudentLoanApp.java
 * Purpose: A user interface student loan calculator application.
 * Coder: Youssef Rajeh
 * Date: April, 2024
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class StudentLoanApp extends JFrame {
	
	ArrayList<Student> studentList = new ArrayList<Student>();

	//Global Variables.
	JPanel inputPanel, displayPanel;
	JTextField studentIDInput, surnameInput, middleNameInput, firstNameInput, aptNumberInput, streetNumberInput, streetNameInput, cityInput, provinceInput,
			postalCodeInput, oslLoanAmountInput, cslLoanAmountInput, studentIDOutput, surnameOutput, middleNameOutput, firstNameOutput, aptNumberOutput,
			streetNumberOutput, streetNameOutput, cityOutput, provinceOutput, postalCodeOutput, cslLoanAmountOutput, oslLoanAmountOutput, amortizationInput;
	DecimalFormat format;
	Font labelFont, buttonFont;
	Color labelColor;
	JButton displayButton;
	JLabel cslRequiredLabel, oslRequiredLabel, totalRequiredLabel, totalWithInterestLabel, originalLoanLabel, totalInterestPaidLabel;
	JSpinner interestRateInput;
	JFormattedTextField interestRateTextField;

	int i = 0;


	public StudentLoanApp() {

		//Boiler plate code 
		super("Youssef Rajeh - 1196323 - Input Form");
		
		this.setLocationRelativeTo(null);
		this.setSize(600, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(0, 10));
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);

		JLabel label = new JLabel("This is Youssef's Student Loan Calculator", SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 25));
		label.setForeground(Color.RED);
		this.add(label, BorderLayout.NORTH);

		inputPanel = new JPanel(new GridLayout(12, 10, 4, 4));
		labelFont = new Font("Arial", Font.ITALIC, 18);
		labelColor = Color.BLUE;
		
		JLabel studentIDLabel = new JLabel(" * StudentID: ");
		studentIDLabel.setFont(labelFont);
		studentIDLabel.setForeground(labelColor);
		inputPanel.add(studentIDLabel);
		studentIDInput = new JTextField(null);
		inputPanel.add(studentIDInput);
		
		JLabel firstNameLabel = new JLabel("   First name: ");
		firstNameLabel.setFont(labelFont);
		firstNameLabel.setForeground(labelColor);
		inputPanel.add(firstNameLabel);
		firstNameInput = new JTextField(null);
		inputPanel.add(firstNameInput);
		
		JLabel middleNameLabel = new JLabel("   Middle name: ");
		middleNameLabel.setFont(labelFont);
		middleNameLabel.setForeground(labelColor);
		inputPanel.add(middleNameLabel);
		middleNameInput = new JTextField(null);
		inputPanel.add(middleNameInput);

		JLabel surnameLabel = new JLabel("   Surname: ");
		surnameLabel.setFont(labelFont);
		surnameLabel.setForeground(labelColor);
		inputPanel.add(surnameLabel);
		surnameInput = new JTextField(null);
		inputPanel.add(surnameInput);

	

	

		JLabel aptNumberLabel = new JLabel("   Apartment number: ");
		aptNumberLabel.setFont(labelFont);
		aptNumberLabel.setForeground(labelColor);
		inputPanel.add(aptNumberLabel);
		aptNumberInput = new JTextField(null);
		inputPanel.add(aptNumberInput);

		JLabel streetNumberLabel = new JLabel("   Street number: ");
		streetNumberLabel.setFont(labelFont);
		streetNumberLabel.setForeground(labelColor);
		inputPanel.add(streetNumberLabel);
		streetNumberInput = new JTextField(null);
		inputPanel.add(streetNumberInput);

		JLabel streetNameLabel = new JLabel("   Street name: ");
		streetNameLabel.setFont(labelFont);
		streetNameLabel.setForeground(labelColor);
		inputPanel.add(streetNameLabel);
		streetNameInput = new JTextField(null);
		inputPanel.add(streetNameInput);

		JLabel cityLabel = new JLabel("   City: ");
		cityLabel.setFont(labelFont);
		cityLabel.setForeground(labelColor);
		inputPanel.add(cityLabel);
		cityInput = new JTextField(null);
		inputPanel.add(cityInput);

		JLabel provinceLabel = new JLabel("   Province: ");
		provinceLabel.setFont(labelFont);
		provinceLabel.setForeground(labelColor);
		inputPanel.add(provinceLabel);
		provinceInput = new JTextField(null);
		inputPanel.add(provinceInput);

		JLabel postalCodeLabel = new JLabel("   Postal code: ");
		postalCodeLabel.setFont(labelFont);
		postalCodeLabel.setForeground(labelColor);
		inputPanel.add(postalCodeLabel);
		postalCodeInput = new JTextField(null);
		inputPanel.add(postalCodeInput);

		JLabel cslLoanAmountLabel = new JLabel(" * CSL loan amount: $");
		cslLoanAmountLabel.setFont(labelFont);
		cslLoanAmountLabel.setForeground(labelColor);
		inputPanel.add(cslLoanAmountLabel);
		cslLoanAmountInput = new JTextField(null);
		inputPanel.add(cslLoanAmountInput);

		JLabel oslLoanAmountLabel = new JLabel(" * OSL loan amount: $");
		oslLoanAmountLabel.setFont(labelFont);
		oslLoanAmountLabel.setForeground(labelColor);
		inputPanel.add(oslLoanAmountLabel);
		oslLoanAmountInput = new JTextField(null);
		inputPanel.add(oslLoanAmountInput);

		this.add(inputPanel, BorderLayout.CENTER);		
	        
	        
		JPanel submissionPanel = new JPanel(new GridLayout(1, 3, 2, 0));
		buttonFont = new Font("Arial", Font.BOLD, 22);
		submissionPanel.setBackground(Color.PINK);
		JButton clearButton = new JButton("Clear");		
		clearButton.setFont(buttonFont);
		clearButton.setBackground(Color.YELLOW);
		clearButton.addActionListener(new clearButtonEvent());
		clearButton.setForeground(Color.RED);
		submissionPanel.add(clearButton);

		JButton saveButton = new JButton("Save data");
		saveButton.setFont(buttonFont);
		saveButton.setBackground(Color.YELLOW);
		saveButton.addActionListener(new saveButtonEvent());
		saveButton.setForeground(Color.RED);
		submissionPanel.add(saveButton);

		displayButton = new JButton("Display");
		displayButton.setFont(buttonFont);
		displayButton.setBackground(Color.YELLOW);
		displayButton.addActionListener(new displayButtonEvent());
		displayButton.setForeground(Color.RED);
		submissionPanel.add(displayButton);

		this.add(submissionPanel, BorderLayout.SOUTH);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
		

	}//End of constructor.


	/*
	 * Class Name: clearButtonEvent
	 * Coder  :Youssef Rajeh
	 * Purpose:    To implement ActionListener for the button to clear the list.
	 * Date:       April, 2024
	 */
	private class clearButtonEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			//Resets the values.
			studentIDInput.setText(null);			
			firstNameInput.setText(null);
			middleNameInput.setText(null);
			surnameInput.setText(null);			
			aptNumberInput.setText(null);
			streetNumberInput.setText(null);
			streetNameInput.setText(null);
			cityInput.setText(null);
			provinceInput.setText(null);
			postalCodeInput.setText(null);
			cslLoanAmountInput.setText(null);
			oslLoanAmountInput.setText(null);

		}//End of actionPerformed() method.

	}//End of clearButtonEvent class.


	/**
	 * Class Name: saveButtonEvent
	 * Purpose:    To implement ActionListener for the button to save the list.
	 * Date:       April, 2024
	 */
	private class saveButtonEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			boolean isValid = runValidation();

			//If isValid is true, add the new record to the student ArrayList.
			if(isValid == true) {
				Student newRecord = new Student(studentIDInput.getText(), surnameInput.getText(), middleNameInput.getText(), firstNameInput.getText(), aptNumberInput
						.getText(), streetNumberInput.getText(), streetNameInput.getText(), cityInput.getText(), provinceInput.getText(), postalCodeInput.getText(), Double
								.parseDouble(cslLoanAmountInput.getText()), Double.parseDouble(oslLoanAmountInput.getText()));
				studentList.add(newRecord);

				JOptionPane.showMessageDialog(inputPanel, "Record saved.");
			}

		}//End of actionPerformed() method.

	}//End of saveButtonEvent class.


	/**
	 * Class Name: displayButtonEvent
	 * Purpose:    To implement ActionListener for the button to clear display the student list.
	 * Date:       April, 2024
	 */
	private class displayButtonEvent extends JFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if(!studentList.isEmpty()) {
				//Creates the display form.
				displayButton.setEnabled(false);
				this.setTitle("Student Records and Repayment Calculation Form");
				this.setLocationRelativeTo(null);
				this.setSize(800, 500);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setLayout(new BorderLayout(0, 10));
				
				 JPanel parentPanel = new JPanel(new GridLayout(1, 2));

				displayPanel = new JPanel(new GridLayout(14, 2, 5, 10));
				Color customColor = new Color(150, 206, 250);
				displayPanel.setBackground(customColor);
				
				JLabel studentIDLabel = new JLabel("   StudentID: ");
				studentIDLabel.setFont(labelFont);
				studentIDLabel.setForeground(labelColor);
				displayPanel.add(studentIDLabel);
				studentIDOutput = new JTextField(studentList.get(i).getStudentID());
				studentIDOutput.setEditable(false);
				displayPanel.add(studentIDOutput);
				
				JLabel firstNameLabel = new JLabel("   First name: ");
				firstNameLabel.setFont(labelFont);
				firstNameLabel.setForeground(labelColor);
				displayPanel.add(firstNameLabel);
				firstNameOutput = new JTextField(studentList.get(i).getFirstName());
				firstNameOutput.setEditable(false);
				displayPanel.add(firstNameOutput);
				
				JLabel middleNameLabel = new JLabel("   Middle name: ");
				middleNameLabel.setFont(labelFont);
				middleNameLabel.setForeground(labelColor);
				displayPanel.add(middleNameLabel);
				middleNameOutput = new JTextField(studentList.get(i).getMiddleName());
				middleNameOutput.setEditable(false);
				displayPanel.add(middleNameOutput);

				JLabel surnameLabel = new JLabel("   Surname: ");
				surnameLabel.setFont(labelFont);
				surnameLabel.setForeground(labelColor);
				displayPanel.add(surnameLabel);
				surnameOutput = new JTextField(studentList.get(i).getSurname());
				surnameOutput.setEditable(false);
				displayPanel.add(surnameOutput);
				

				JLabel aptNumberLabel = new JLabel("   Apartment number: ");
				aptNumberLabel.setFont(labelFont);
				aptNumberLabel.setForeground(labelColor);
				displayPanel.add(aptNumberLabel);
				aptNumberOutput = new JTextField(studentList.get(i).getAptNumber());
				aptNumberOutput.setEditable(false);
				displayPanel.add(aptNumberOutput);

				JLabel streetNumberLabel = new JLabel("   Street number: ");
				streetNumberLabel.setFont(labelFont);
				streetNumberLabel.setForeground(labelColor);
				displayPanel.add(streetNumberLabel);
				streetNumberOutput = new JTextField(studentList.get(i).getStreetNumber());
				streetNumberOutput.setEditable(false);
				displayPanel.add(streetNumberOutput);

				JLabel streetNameLabel = new JLabel("   Street name: ");
				streetNameLabel.setFont(labelFont);
				streetNameLabel.setForeground(labelColor);
				displayPanel.add(streetNameLabel);
				streetNameOutput = new JTextField(studentList.get(i).getStreetName());
				streetNameOutput.setEditable(false);
				displayPanel.add(streetNameOutput);

				JLabel cityLabel = new JLabel("   City: ");
				cityLabel.setFont(labelFont);
				cityLabel.setForeground(labelColor);
				displayPanel.add(cityLabel);
				cityOutput = new JTextField(studentList.get(i).getCity());
				cityOutput.setEditable(false);
				displayPanel.add(cityOutput);

				JLabel provinceLabel = new JLabel("   Province: ");
				provinceLabel.setFont(labelFont);
				provinceLabel.setForeground(labelColor);
				displayPanel.add(provinceLabel);
				provinceOutput = new JTextField(studentList.get(i).getProvince());
				provinceOutput.setEditable(false);
				displayPanel.add(provinceOutput);

				JLabel postalCodeLabel = new JLabel("   Postal code: ");
				postalCodeLabel.setFont(labelFont);
				postalCodeLabel.setForeground(labelColor);
				displayPanel.add(postalCodeLabel);
				postalCodeOutput = new JTextField(studentList.get(i).getPostalCode());
				postalCodeOutput.setEditable(false);
				displayPanel.add(postalCodeOutput);

				JLabel cslLoanAmountLabel = new JLabel("   CSL loan amount: $");
				cslLoanAmountLabel.setFont(labelFont);
				cslLoanAmountLabel.setForeground(labelColor);
				displayPanel.add(cslLoanAmountLabel);
				cslLoanAmountOutput = new JTextField(String.valueOf(studentList.get(i).getCslLoanAmount()));
				cslLoanAmountOutput.setEditable(false);
				displayPanel.add(cslLoanAmountOutput);

				JLabel oslLoanAmountLabel = new JLabel("   OSL loan amount: $");
				
				oslLoanAmountLabel.setFont(labelFont);
				oslLoanAmountLabel.setForeground(labelColor);
				displayPanel.add(oslLoanAmountLabel);
				oslLoanAmountOutput = new JTextField(String.valueOf(studentList.get(i).getOslLoanAmount()));
				oslLoanAmountOutput.setEditable(false);
				displayPanel.add(oslLoanAmountOutput);

				JLabel interestRateLabel = new JLabel("   Prime Interest Rate: %");
				interestRateLabel.setFont(labelFont);
				interestRateLabel.setForeground(labelColor);
				
				
				
				displayPanel.add(interestRateLabel);
				interestRateInput = new JSpinner(new SpinnerNumberModel(4.25, 0.00, 10.00, 0.25));
				JSpinner.NumberEditor interestRateEditor = (NumberEditor)interestRateInput.getEditor();
				interestRateEditor.getTextField().setHorizontalAlignment(SwingConstants.LEFT);
				format = interestRateEditor.getFormat();
				format.setMinimumFractionDigits(2);
				interestRateTextField = ((JSpinner.DefaultEditor)interestRateInput.getEditor()).getTextField();
				interestRateTextField.setText("0.00");
				interestRateTextField.setEditable(false);
				displayPanel.add(interestRateInput);

				JLabel amortizationLabel = new JLabel("   Amortization Period in months: ");
				amortizationLabel.setFont(labelFont);
				amortizationLabel.setForeground(labelColor);
				displayPanel.add(amortizationLabel);
				amortizationInput = new JTextField(null);
				displayPanel.add(amortizationInput);

				this.add(displayPanel, BorderLayout.NORTH);

				JPanel calculationPanel = new JPanel(new GridLayout(6, 1, 0, 10));
				Color customColor1 = new Color(135, 206, 250);
				calculationPanel.setBackground(customColor1);
				Color labelColor = Color.RED;
				
				cslRequiredLabel = new JLabel("   CSL monthly payment: ");
				cslRequiredLabel.setFont(labelFont);
				
				cslRequiredLabel.setForeground(labelColor);
				calculationPanel.add(cslRequiredLabel);
				oslRequiredLabel = new JLabel("   OSL monthly payment: ");
				oslRequiredLabel.setFont(labelFont);
				oslRequiredLabel.setForeground(labelColor);
				calculationPanel.add(oslRequiredLabel);
				totalRequiredLabel = new JLabel("   Total monthly payment: ");
				totalRequiredLabel.setFont(labelFont);
				totalRequiredLabel.setForeground(labelColor);
				calculationPanel.add(totalRequiredLabel);
				totalWithInterestLabel = new JLabel("   Total payment with interest: ");
				totalWithInterestLabel.setFont(labelFont);
				totalWithInterestLabel.setForeground(labelColor);
				calculationPanel.add(totalWithInterestLabel);
				originalLoanLabel = new JLabel("   Original amount borrowed: ");
				originalLoanLabel.setFont(labelFont);
				originalLoanLabel.setForeground(labelColor);
				calculationPanel.add(originalLoanLabel);
				totalInterestPaidLabel = new JLabel("   Total interest paid: ");
				totalInterestPaidLabel.setFont(labelFont);
				totalInterestPaidLabel.setForeground(labelColor);
				calculationPanel.add(totalInterestPaidLabel);

				this.add(calculationPanel, BorderLayout.CENTER);

				JPanel submissionPanel = new JPanel(new GridLayout(1, 3, 2, 0));
				buttonFont = new Font("Arial", Font.BOLD, 20);

				JButton previousButton = new JButton("Previous");
				
				previousButton.setFont(buttonFont);
				previousButton.setForeground(Color.RED);
				previousButton.setBackground(Color.YELLOW);
				previousButton.addActionListener(new previousButtonEvent());
				submissionPanel.add(previousButton);

				JButton calculateButton = new JButton("Calculate");
				calculateButton.setFont(buttonFont);
				calculateButton.setForeground(Color.RED);
				calculateButton.setBackground(Color.YELLOW);
				calculateButton.addActionListener(new calculateButtonEvent());
				submissionPanel.add(calculateButton);

				JButton nextButton = new JButton("Next");
				nextButton.setFont(buttonFont);
				nextButton.setForeground(Color.RED);
				nextButton.setBackground(Color.YELLOW);
				nextButton.addActionListener(new nextButtonEvent());
				submissionPanel.add(nextButton);

				
				 // Add both panels to the parentPanel
		        parentPanel.add(displayPanel);
		        parentPanel.add(calculationPanel);
		        
		        this.add(parentPanel, BorderLayout.CENTER);
				this.add(submissionPanel, BorderLayout.SOUTH);

				this.setLocationRelativeTo(null);
				this.setVisible(true);

			}else {
				JOptionPane.showMessageDialog(inputPanel, "Student list is empty.");
			}

		}//End of actionPerformed() method.

	}//End of displayButtonEvent class.


	/**
	 * Method Name: updateDisplay
	 * Coder: 		Youssef Rajeh
	 * Purpose:     To get rid of recursive code that will be used twice.
	 * Accepts:     Nothing.
	 * Returns:     Nothing.
	 * Date:        April, 2024
	 */
	void updateDisplay() {

		//Updates the list.
		studentIDOutput.setText(studentList.get(i).getStudentID());
		surnameOutput.setText(studentList.get(i).getSurname());
		middleNameOutput.setText(studentList.get(i).getMiddleName());
		firstNameOutput.setText(studentList.get(i).getFirstName());
		aptNumberOutput.setText(studentList.get(i).getAptNumber());
		streetNumberOutput.setText(studentList.get(i).getStreetNumber());
		streetNameOutput.setText(studentList.get(i).getStreetName());
		cityOutput.setText(studentList.get(i).getCity());
		provinceOutput.setText(studentList.get(i).getProvince());
		postalCodeOutput.setText(studentList.get(i).getPostalCode());
		cslLoanAmountOutput.setText(String.valueOf(studentList.get(i).getCslLoanAmount()));
		oslLoanAmountOutput.setText(String.valueOf(studentList.get(i).getOslLoanAmount()));

		//Default values.
		interestRateTextField.setText("0.00");
		amortizationInput.setText(null);
		cslRequiredLabel.setText("   CSL monthly payment: ");
		oslRequiredLabel.setText("   OSL monthly payment: ");
		totalRequiredLabel.setText("   Total monthly payment: ");
		totalWithInterestLabel.setText("   Total payment with interest: ");
		originalLoanLabel.setText("   Original amount borrowed: ");
		totalInterestPaidLabel.setText("   Total interest paid: ");

	}//End of updateDisplay


	/**
	 * Class Name:	previousButtonEvent
	 * Coder: 		Youssef Rajeh
	 * Purpose:		To implement ActionListener for the button to navigate to the previous list in the display frame.
	 * Date:		April, 2024
	 */
	private class previousButtonEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			//Checks if the viewed list is not the first.
			if(i > 0) {
				--i;
				updateDisplay();

			}else {
				JOptionPane.showMessageDialog(displayPanel, "Reached the first student in the list.");
			}

		}//End of actionPerformed

	}//End of previousButtonEvent
	
	
	
	
	
	/**
	 * Method name : validateAmortizationPeriod
	 * Youssef Rajeh
	 * April 2024
	 * Validates the amortization period entered by the user.
	 * Ensures it is a non negative integer and does not exceed 120 months.
	 *
	 * @return true if the input is valid, false otherwise.
	 */
	private boolean validateAmortizationPeriod() {
	    try {
	        int amortizationPeriod = Integer.parseInt(amortizationInput.getText());
	        if (amortizationPeriod < 1 || amortizationPeriod > 120) {
	            // If the period is outside the valid range, show an error message
	            JOptionPane.showMessageDialog(this, "Amortization period must be between 1 and 120 months.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
	    } catch (NumberFormatException e) {
	        // If the input is not an integer, show an error message
	        JOptionPane.showMessageDialog(this, "Amortization period must be a valid integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	    return true; // The input is valid
	}

	/**
	 * Class Name:		calculateButtonEvent
	 * Coder: 			Youssef Rajeh
	 * Purpose:			To implement ActionListener for the button to begin calculation.
	 * Date: 			April, 2024
	 */
	private class calculateButtonEvent implements ActionListener, y_a_LoanPayable {

		@Override
		public void actionPerformed(ActionEvent e) {
		    if (!validateAmortizationPeriod()) {
		        // If validation fails, exit the method to prevent further processing
		        return;
		    }
		    if (amortizationInput.getText().isBlank()) {
		        JOptionPane.showMessageDialog(displayPanel, "Please make sure the Amortization period is not blank.");
		    } else {
		        DecimalFormat formatter = new DecimalFormat("$#,##0.00");

		        // Correctly calculate the monthly interest rates for CSL and OSL
		        double annualRateCSL = Double.parseDouble(interestRateTextField.getText()) + 2.5; // CSL rate is prime rate + 2.5%
		        double annualRateOSL = Double.parseDouble(interestRateTextField.getText()) + 1.0; // OSL rate is prime rate + 1.0%
		        double studentCslLoan = studentList.get(i).getCslLoanAmount();
		        double studentOslLoan = studentList.get(i).getOslLoanAmount();
		        int amortizationPeriod = Integer.parseInt(amortizationInput.getText());

		        // Use the corrected calculateLoanPayment method with the proper annual rates
		        double monthlyPaymentCSL = calculateLoanPayment(studentCslLoan, annualRateCSL, amortizationPeriod);
		        double monthlyPaymentOSL = calculateLoanPayment(studentOslLoan, annualRateOSL, amortizationPeriod);
		        double totalMonthlyPayment = monthlyPaymentCSL + monthlyPaymentOSL;
		        double totalPaymentWithInterest = totalMonthlyPayment * amortizationPeriod;
		        double totalInterestPaid = totalPaymentWithInterest - (studentCslLoan + studentOslLoan);

		        // Displays calculated results using the formatter for currency
		        
		        Color numberColor = Color.BLACK;
		        cslRequiredLabel.setText("   CSL monthly payment: " + formatter.format(monthlyPaymentCSL));
		        cslRequiredLabel.setForeground(numberColor);
		        oslRequiredLabel.setText("   OSL monthly payment: " + formatter.format(monthlyPaymentOSL));
		        oslRequiredLabel.setForeground(numberColor);
		        totalRequiredLabel.setText("   Total monthly payment: " + formatter.format(totalMonthlyPayment));
		        totalRequiredLabel.setForeground(numberColor);
		        totalWithInterestLabel.setText("   Total payment with interest: " + formatter.format(totalPaymentWithInterest));
		        totalWithInterestLabel.setForeground(numberColor);
		        originalLoanLabel.setText("   Original amount borrowed: " + formatter.format(studentCslLoan + studentOslLoan));
		        originalLoanLabel.setForeground(numberColor);
		        totalInterestPaidLabel.setText("   Total interest paid: " + formatter.format(totalInterestPaid));
		        totalInterestPaidLabel.setForeground(numberColor);
		    }
		}//End of actionPerformed.

		@Override
		public double calculateLoanPayment(double amount, double annualRate, int amortization) {
		    // Convert annual interest rate from percentage to decimal
		    // Example: 4.25% becomes 0.0425
		    double annualRateDecimal = annualRate / 100.0;

		    // Convert annual rate to monthly rate in decimal
		    double monthlyRateDecimal = annualRateDecimal / 12.0;

		    // Apply the formula to calculate monthly payment
		    double monthlyPayment = (amount * monthlyRateDecimal) * Math.pow((1 + monthlyRateDecimal), amortization) 
		                            / (Math.pow((1 + monthlyRateDecimal), amortization) - 1);

		    // Round the monthly payment to the nearest cent
		    return Math.round(monthlyPayment * 100.0) / 100.0;
		}

	}//End of editButtonEvent


	/**
	 * Class Name:	 nextButtonEvent
	 * Coder: 		 Youssef Rajeh
	 * Purpose:		 To implement ActionListener for the button to navigate to the next list
	 * 				 in the display frame.
	 * Date:	 	 April, 2024
	 */
	private class nextButtonEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			//Checks if the viewed list is not at the end.
			if(studentList.size() > i + 1) {
				++i;
				updateDisplay();
			}else {
				JOptionPane.showMessageDialog(displayPanel, "Reached the last student in the list.");
			}

		}//End of actionPerformed

	}//End of nextButtonEvent


	/**
	 * Method Name: 	runValidation
	 * Coder: 		    Youssef Rajeh
	 * Purpose: 		Checks if the input in the fields are legal.
	 * Accepts: 		Nothing.
	 * Returns:	 		A boolean.
	 * Date:	 		April, 2024
	 */
	public boolean runValidation() {
		if (!studentIDInput.getText().isBlank()) {
		    // Check if the studentIDInput is exactly 7 digits long
		    if (studentIDInput.getText().length() == 7 && studentIDInput.getText().matches("^\\d{7}$")) {
		        // This means the input is exactly 7 digits long and valid
		    } else {
		        JOptionPane.showMessageDialog(inputPanel, "Invalid entry, please make sure StudentID is exactly 7 digits long.");
		        return false;
		    }
		} else {
		    JOptionPane.showMessageDialog(inputPanel, "Please make sure StudentID is not blank.");
		    return false;
		}

		int i = 0;

		if(!studentIDInput.getText().isBlank()) {

			while(i < studentIDInput.getText().length()) {

				if(!Character.isDigit(studentIDInput.getText().charAt(i))) {
					JOptionPane.showMessageDialog(inputPanel, "Invalid entry, please make sure StudentID input contains only numbers.");
					return false;
				}

				++i;
			}//End of while

		}else {
			JOptionPane.showMessageDialog(inputPanel, "Please make sure StudentID is not blank.");
			return false;
		}

		i = 0;

		if(!surnameInput.getText().isBlank()) {

			while(i < surnameInput.getText().length()) {

				if(Character.isDigit(surnameInput.getText().charAt(i))) {
					JOptionPane.showMessageDialog(inputPanel, "Invalid entry, please make sure Surname input contains only letters.");
					return false;
				}

				++i;
			}//End of while

		}else {
			JOptionPane.showMessageDialog(inputPanel, "Please make sure Surname is not blank.");
			return false;
		}

		i = 0;

		while(i < middleNameInput.getText().length()) {

			if(!Character.isAlphabetic(middleNameInput.getText().charAt(i))) {
				JOptionPane.showMessageDialog(inputPanel, "Invalid entry, please make sure Middle name input contains only letters.");
				return false;
			}

			++i;
		}//End of while

		i = 0;

		if(!firstNameInput.getText().isBlank()) {

			while(i < firstNameInput.getText().length()) {

				if(Character.isDigit(firstNameInput.getText().charAt(i))) {
					JOptionPane.showMessageDialog(inputPanel, "Invalid entry, please make sure First name input contains only letters.");
					return false;
				}

				++i;
			}//End of while

		}else {
			JOptionPane.showMessageDialog(inputPanel, "Please make sure First name is not blank.");
			return false;
		}

		i = 0;

		while(i < aptNumberInput.getText().length()) {

			if(!Character.isDigit(aptNumberInput.getText().charAt(i))) {
				JOptionPane.showMessageDialog(inputPanel, "Invalid entry, please make sure Appartment number input contains only numbers.");
				return false;
			}

			++i;
		}//End of while

		i = 0;

		while(i < streetNumberInput.getText().length()) {

			if(!Character.isDigit(streetNumberInput.getText().charAt(i))) {
				JOptionPane.showMessageDialog(inputPanel, "Invalid entry, please make sure Street number input contains only numbers.");
				return false;
			}

			++i;
		}//End of while

		i = 0;

		if(!cslLoanAmountInput.getText().isBlank()) {

			try {
				isNegative(Double.parseDouble(cslLoanAmountInput.getText()));
			}catch(y_a_NegativeValueException e) {
				JOptionPane.showMessageDialog(inputPanel, e.toString(), "Invalid Entry", JOptionPane.OK_OPTION);
				cslLoanAmountInput.setText("" + Math.abs(Double.parseDouble(cslLoanAmountInput.getText())));
			}//End of catch block.

			while(i < cslLoanAmountInput.getText().length()) {

				if(Character.isAlphabetic(cslLoanAmountInput.getText().charAt(i))) {
					JOptionPane.showMessageDialog(inputPanel, "Invalid entry, please make sure CSL loan amount input contains only numbers.");
					return false;
				}

				++i;
			}//End of while

		}else {
			JOptionPane.showMessageDialog(inputPanel, "Please make sure CSL loan amount is not blank.");
			return false;
		}

		i = 0;

		if(!oslLoanAmountInput.getText().isBlank()) {

			try {
				isNegative(Double.parseDouble(oslLoanAmountInput.getText()));
			}catch(y_a_NegativeValueException e) {
				JOptionPane.showMessageDialog(inputPanel, e.toString(), "Illegal Value Used", JOptionPane.OK_OPTION);
				oslLoanAmountInput.setText("" + Math.abs(Double.parseDouble(oslLoanAmountInput.getText())));
			}//End of catch block.

			while(i < oslLoanAmountInput.getText().length()) {

				if(Character.isAlphabetic(oslLoanAmountInput.getText().charAt(i))) {
					JOptionPane.showMessageDialog(inputPanel, "Invalid entry, please make sure OSL loan amount input contains only numbers.");
					return false;
				}

				++i;
			}//End of while

		}else {
			JOptionPane.showMessageDialog(inputPanel, "Please make sure OSL loan amount is not blank.");
			return false;
		}

		return true;

	}//End of runValidation


	/**
	 * Method Name:  isNegative
	 * Coder: 		 Youssef Rajeh
	 * Purpose:      To check if the value passed is a negative number.
	 * Accepts:		 A double.
	 * Returns:      Nothing.
	 * Date:		 April, 2024
	 */
	public void isNegative(double value) throws y_a_NegativeValueException {
	    if(value < 0) {
	        // Provide a more user-friendly error message.
	        throw new y_a_NegativeValueException("\nThe value cannot be negative. The Entered Value will be converted to a positive value. Click ok To Continue");
	    }
	}//End of isNegative


	public static void main(String[] args) {

		new StudentLoanApp();

	}//End of main

}//End of StudentLoanApp