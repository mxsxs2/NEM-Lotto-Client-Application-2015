/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package options;

import java.sql.SQLException;

/**
 *
 * @author Mxsxs2
 */
public class SiteTexts extends javax.swing.JPanel {
    private final String[] texts= new String[11];
    /*
        0=Desc
        1=Option1
        2=Option2
        3=Option3
        4=Option4
        5=opt1text
        6=opt2text
        7=opt3text
        8=opt4text
        9=opening
        
    
     * 
    */
    /**
     * Creates new form SiteTexts
     */
    public SiteTexts() {
        initComponents();
        super.setBounds(0,0,870,577);
        this.getDB();
        this.setFileds();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jOptL1 = new javax.swing.JTextField();
        jOptD1 = new javax.swing.JTextField();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jOptL2 = new javax.swing.JTextField();
        jOptD2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jOptL3 = new javax.swing.JTextField();
        jOptD3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jOptL4 = new javax.swing.JTextField();
        jOptD4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDescLayered = new javax.swing.JLayeredPane();
        jDescField = new javax.swing.JTextField();
        jWelcLayered = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jWTextArea = new javax.swing.JTextArea();
        jSaveButton = new javax.swing.JButton();
        jRespLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(738, 557));
        setMinimumSize(new java.awt.Dimension(738, 557));
        setPreferredSize(new java.awt.Dimension(738, 557));

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Option 1"));

        jLabel1.setText("Label");

        jLabel2.setText("Option description");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jOptL1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jOptD1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(jOptL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jOptD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jOptL1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jOptD1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Option 2"));

        jLabel3.setText("Option description");

        jLabel4.setText("Label");

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jOptL2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jOptD2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addComponent(jOptL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jOptD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane2.setLayer(jOptL2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jOptD2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Option 3"));

        jLabel5.setText("Option description");

        jLabel6.setText("Label");

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jOptL3, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jOptD3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addComponent(jOptL3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jOptD3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane3.setLayer(jOptL3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jOptD3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("Option 4"));

        jLabel7.setText("Option description");

        jLabel8.setText("Label");

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jOptL4, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jOptD4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addComponent(jOptL4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jOptD4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane4.setLayer(jOptL4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jOptD4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jDescLayered.setBorder(javax.swing.BorderFactory.createTitledBorder("Site description"));

        javax.swing.GroupLayout jDescLayeredLayout = new javax.swing.GroupLayout(jDescLayered);
        jDescLayered.setLayout(jDescLayeredLayout);
        jDescLayeredLayout.setHorizontalGroup(
            jDescLayeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDescLayeredLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDescField, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDescLayeredLayout.setVerticalGroup(
            jDescLayeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDescLayeredLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDescField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDescLayered.setLayer(jDescField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jWelcLayered.setBorder(javax.swing.BorderFactory.createTitledBorder("Home welcome text"));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(166, 96));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(166, 96));

        jWTextArea.setColumns(20);
        jWTextArea.setRows(5);
        jWTextArea.setMaximumSize(new java.awt.Dimension(164, 94));
        jWTextArea.setMinimumSize(new java.awt.Dimension(164, 94));
        jScrollPane1.setViewportView(jWTextArea);

        javax.swing.GroupLayout jWelcLayeredLayout = new javax.swing.GroupLayout(jWelcLayered);
        jWelcLayered.setLayout(jWelcLayeredLayout);
        jWelcLayeredLayout.setHorizontalGroup(
            jWelcLayeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jWelcLayeredLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jWelcLayeredLayout.setVerticalGroup(
            jWelcLayeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jWelcLayeredLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jWelcLayered.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jSaveButton.setText("Save changes");
        jSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveButtonActionPerformed(evt);
            }
        });

        this.jRespLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLayeredPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredPane4))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jWelcLayered, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDescLayered, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRespLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jRespLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDescLayered)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jWelcLayered, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(jSaveButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveButtonActionPerformed
        this.fillDB();
        
    }//GEN-LAST:event_jSaveButtonActionPerformed
    private void fillDB(){
        this.jRespLabel.setText("Saving...");
        frame.MysqlAccess SQL= new frame.MysqlAccess();
        String[] Collumns= new String[]{"Desc","opt1text","opt2text","opt3text","opt4text","Option1","Option2","Option3","Option4","opening"};
        String[] Values=new String[]{"","","","","","","","","",""};
        if(this.jDescField.getText().length()>0)  Values[0]=this.jDescField.getText();
        if(this.jOptL1.getText().length()>0)      Values[1]=this.jOptL1.getText();
        if(this.jOptL2.getText().length()>0)      Values[2]=this.jOptL2.getText();
        if(this.jOptL3.getText().length()>0)      Values[3]=this.jOptL3.getText();
        if(this.jOptL4.getText().length()>0)      Values[4]=this.jOptL4.getText();
        if(this.jOptD1.getText().length()>0)      Values[5]=this.jOptD1.getText();
        if(this.jOptD2.getText().length()>0)      Values[6]=this.jOptD2.getText();
        if(this.jOptD3.getText().length()>0)      Values[7]=this.jOptD3.getText();
        if(this.jOptD4.getText().length()>0)      Values[8]=this.jOptD4.getText();
        if(this.jWTextArea.getText().length()>0)  Values[9]=this.jWTextArea.getText();
        Boolean resp = SQL.PreparedUpdate("sitetexts", Collumns, Values, "`id`=0", "1");
        if(resp){
            this.jRespLabel.setText("Saved");
            this.getDB();
            this.setFileds();
        }else{
            this.jRespLabel.setText("Could not save the data. Try again.");
        }
    }
    private void getDB(){
        try {
            frame.MysqlAccess SQL= new frame.MysqlAccess();
            java.sql.ResultSet RS= SQL.PreparedSelect("sitetexts", new String[]{"*"}, "", "0", "");
            
            if(RS.first()){
                this.texts[0]=RS.getString("Desc");
                this.texts[1]=RS.getString("Option1");
                this.texts[2]=RS.getString("Option2");
                this.texts[3]=RS.getString("Option3");
                this.texts[4]=RS.getString("Option4");
                this.texts[5]=RS.getString("opt1text");
                this.texts[6]=RS.getString("opt2text");
                this.texts[7]=RS.getString("opt3text");
                this.texts[8]=RS.getString("opt4text");
                this.texts[9]=RS.getString("opening");
                
                //System.out.print(Arrays.toString(this.texts));
            }
        } catch (SQLException ex) {
            
        }
    }
    private void setFileds(){
        this.jOptL1.setText(this.texts[5]);
        this.jOptL2.setText(this.texts[6]);
        this.jOptL3.setText(this.texts[7]);
        this.jOptL4.setText(this.texts[8]);
        this.jOptD1.setText(this.texts[1]);
        this.jOptD2.setText(this.texts[2]);
        this.jOptD3.setText(this.texts[3]);
        this.jOptD4.setText(this.texts[4]);
        this.jDescField.setText(this.texts[0]);
        this.jWTextArea.setText(this.texts[9]);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jDescField;
    private javax.swing.JLayeredPane jDescLayered;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JTextField jOptD1;
    private javax.swing.JTextField jOptD2;
    private javax.swing.JTextField jOptD3;
    private javax.swing.JTextField jOptD4;
    private javax.swing.JTextField jOptL1;
    private javax.swing.JTextField jOptL2;
    private javax.swing.JTextField jOptL3;
    private javax.swing.JTextField jOptL4;
    private javax.swing.JLabel jRespLabel;
    private javax.swing.JButton jSaveButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jWTextArea;
    private javax.swing.JLayeredPane jWelcLayered;
    // End of variables declaration//GEN-END:variables
}
