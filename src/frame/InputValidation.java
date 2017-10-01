/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author PC'
 */
public class InputValidation implements DocumentListener{
    private final Object WhatFired;          //The object what fired the event
    private final String ValidationType;     //The type of the validation: number
    private int Max=0;                 //If  teh conetent of the field is a number this is the max what they can input. 0 is ignored
    private int MaxLength=0;           //The maximum length of the field. 0 is ignored
    InputValidation(Object Field, String ValidationType, int Max, int MaxLength){ //The constructor needs for of the defined variables.
        this.WhatFired=Field;                            //Set the Field
        this.ValidationType=ValidationType;              //Set the validation of the type
        this.Max=Max;                                    //Set the highest number what they can input
        this.MaxLength=MaxLength;                        //Set the maximum length of the field
    }
            @Override
            public void insertUpdate(DocumentEvent e) {            //If the evnet was insert
                this.ValidationTypeChooser();  
            }
            @Override
            public void removeUpdate(DocumentEvent e) {            //If the event was update
                this.ValidationTypeChooser();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {           //If they removed a character
                this.ValidationTypeChooser();
            }
    private void ValidationTypeChooser(){          //The method will choose wich type of the validaton is needed then call.
        switch (this.ValidationType){
            case "number":                         //If its number type
                    this.NumberValidation();
                break;
            default:
                break;
        }
    } 
    private void NumberValidation(){                 //Validating the number textfield
        
        Runnable Validate = () -> {
            if(WhatFired instanceof JTextField){                                        //Check the cast of the object
                JTextField CheckedField=(JTextField)WhatFired;                          //Then cast it
                
                if(!CheckedField.getText().equals("") && CheckedField.getText()!=null){ //Check if the field is empty if it is then do nothing
                    String Value=CheckedField.getText();                             //Geth the value of the field
                    char[] ValueArray=Value.toCharArray();                           //Creat an array of the value
                    String NewValue="";                                              //The new value of the field
                    Boolean Dot=false;                                               //If there was a . already in the field
                    if(MaxLength>0){                                                 //If the MaxLength "turned on" check the length of the field
                        if(ValueArray.length>MaxLength){
                            CheckedField.setText(String.valueOf(ValueArray).substring(0,MaxLength));  //If its longer then cut the rest of the text
                            return;                                                  //Then exit from the method
                        }
                    }
                    //if (Value.matches("[-+]?[0-9]*\\.?[0-9]+")) {
                    int afterdot=0;
                    for (char c: ValueArray) {                                   //Check every character in the field
                        if(Character.isDigit(c) || (c=='.' && Dot==false)){  //Check if the charater is number or (is it a . and wasnt in the field yet)
                            if(c=='.'){                                  //If its a . then set the Dot true so next time it will ignore the dot
                                Dot=true;
                            }
                            if(Dot==true){
                                afterdot++;
                            }
                            if(afterdot<4){
                                if(afterdot==3){
                                     if(c=='1' || c=='0' || c=='2' || c=='8'|| c=='9'){
                                         c='0';
                                     }else{
                                        c='5';
                                     }
                                }
                                NewValue+=c;                                 //Then add it into the NewValue
                            }
                        }
                        //System.out.println(c+"_"+NewValue);
                    }
                    
                    
                    
                    if(this.Max>0 && !NewValue.equals("")){                    //If the maximum is "turned on" and the NewValue is not emppty
                        if(Character.isDigit(NewValue.charAt(0))){
                            if( Float.parseFloat(NewValue)>=this.Max){             //Then check if the number in the field is bigger then the max
                                NewValue=Integer.toString(this.Max);               //If it is then set it back to the max and exit the loop
                            }
                        }
                    }
                    
                    if(ValueArray.length!=NewValue.length() || !Value.equals(NewValue)){                    //Check if the original length of the text is the same the the filtered one
                        CheckedField.setText(NewValue);                         //If it is not then replace the original one with the filtered one
                    }
                    
                }
            }
        };
        SwingUtilities.invokeLater(Validate);   //Has to 
    }
}