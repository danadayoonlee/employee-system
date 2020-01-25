package dayoon_lee_exercise2;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EmployeeController {
	
	Employee emp;
	List<Employee> employees = new ArrayList<Employee>();

	@FXML
    private Label resultLabel;
	
    @FXML
    private Button addButton;

    @FXML
    private Button displayButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField searchTextField;

    @FXML
    private TextField salaryTextField;

    @FXML
    private TextArea empListTextArea;

    @FXML
    private DatePicker datePicker;
    
    @FXML
    void searchButtonClicked(ActionEvent event) {
    	for (Employee emp : employees)
        {
    		if(!searchTextField.getText().matches("\\d+"))
    		{
    			if (emp.getEmpName().equals(searchTextField.getText()))    		
	        	{  			
	    			resultLabel.setText("Employee Exists.");
	    			break;
	        	}
    			else
        		{
        			resultLabel.setText("Employee does not Exists.");
        		}
    		}
    		if(searchTextField.getText().matches("\\d+"))
    		{
    			if (emp.getEmpId() == Integer.parseInt(searchTextField.getText()))
	        	{  			
	    			resultLabel.setText("Employee Exists.");
	    			break;
	        	}
    			else
        		{
        			resultLabel.setText("Employee does not Exists.");
        		}
    		}
        }
    }

    @FXML
    void displayButtonClicked(ActionEvent event) {
        String result = String.format("Employee ID\tEmployee Name\tDate of joining\t\tSalary%n");
        for (Employee emp : employees)
        {
        	result += emp.toString();
        }
        empListTextArea.setText(result);
    }
    
    @FXML
    void addButtonClicked(ActionEvent event) {
    	resultLabel.setText("");
    	if(Integer.parseInt(idTextField.getText()) >= 100)
    	{
    		boolean duplicate = false;
        	for (Employee emp : employees)
            {
        		if (emp.getEmpId() == Integer.parseInt(idTextField.getText()))
            	{  			
        			duplicate = true;
        			resultLabel.setText("Cannot add dupicate ID. Please try again.");
            	}
            }
        	if(!duplicate)
        	{
    			employees.add(new Employee(Integer.parseInt(idTextField.getText()), nameTextField.getText(), datePicker.getValue().toString(), Double.parseDouble(salaryTextField.getText())));
        	}
    	}
    }
    
    @FXML
    void clearButtonClicked(ActionEvent event) {
    	idTextField.clear();
    	nameTextField.clear();
    	datePicker.getEditor().clear();
    	salaryTextField.clear();
    	searchTextField.clear();
    	empListTextArea.clear();
    	employees.clear();
    }
    
    public void initialize() {
		employees.add(new Employee(100, "Amy Evans", "2018-05-02", 5000));
		employees.add(new Employee(101, "Emma Jenkins", "2018-08-10", 4500));
		employees.add(new Employee(102, "Summer Hill", "2018-09-20", 4500));
		employees.add(new Employee(103, "John Barnes", "2019-03-11", 4000));
		employees.add(new Employee(104, "Donna Bell", "2019-05-24", 3500));
	}
}
