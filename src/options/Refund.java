/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package options;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import org.json.JSONException;

/**
 *
 * @author Mxsxs2
 */
public class Refund extends javax.swing.JPanel {
    private final frame.MysqlAccess SQL= new frame.MysqlAccess();
    private final classes.ConfigReader CR;
    private String[][] Transactions;
    /**
     * Creates new form Refund
     * @param ConfigReader
     */
    public Refund(classes.ConfigReader ConfigReader) {
        initComponents();
        super.setBounds(0,0,870,577);
        this.setTable();
        this.CR=ConfigReader;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPhraseField = new javax.swing.JTextField();
        jRefundButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jRefundedTable = new javax.swing.JTable();
        jResp = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSessionBox = new javax.swing.JComboBox();

        setMaximumSize(new java.awt.Dimension(870, 577));
        setMinimumSize(new java.awt.Dimension(870, 577));
        setPreferredSize(new java.awt.Dimension(870, 577));

        jLabel2.setText("Phrase:");

        jRefundButton.setText("Refund");
        jRefundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRefundButtonActionPerformed(evt);
            }
        });

        jRefundedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jRefundedTable);

        this.jResp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setText("Session:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jResp, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(69, 69, 69)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPhraseField)
                                .addComponent(jSessionBox, 0, 503, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRefundButton))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jResp, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPhraseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSessionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jRefundButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRefundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRefundButtonActionPerformed
        this.refund();
    }//GEN-LAST:event_jRefundButtonActionPerformed

private void refund(){
    this.jResp.setText("");
    String Phrase=this.jPhraseField.getText();
    String Session=(String)this.jSessionBox.getSelectedItem();
    String[] SessionArray=Session.split(" ", 2);
    String SessionID=SessionArray[0].substring(3, SessionArray[0].length());
    if(Phrase.length()>0){
        if(this.getTransactions(SessionID)>0){                                  //Get transactions the function return 0 if there is no transaction
            if(this.getRefunds()>0){                                            //Filter transactions to refunds. the function returns 0 if there is no refunds
                int refunded=0;
                int couldnotrefund=0;
                for(String[] M:this.Transactions){
                    if(this.refundSingle(Phrase, M[2], M[1])){
                        refunded++;
                    }else{
                        couldnotrefund++;
                    }
                }
                if(refunded>0 || couldnotrefund>0){
                    this.jResp.setText(refunded+" transactions were refunded and couldn't refund "+couldnotrefund+" transactions.");
                }
            }else{
                this.jResp.setText("There is no refundable transactions in this session.");
            }
        }else{
            this.jResp.setText("No transactions in this session.");
        }
    }else{
         this.jResp.setText("Fill up the phrase field.");
    }
    //this.refundSingle("survive wrap stranger king waist march just shiver boom deal mom kitche", "100000000", "NXT-2GR5-UW2W-CZ5B-7TJT3");
}    
private int getTransactions(String SessionID){
        try {
            java.sql.ResultSet RS=SQL.PreparedSelect("optionaddresses", new String[]{"*"},"`session`="+SessionID,"1","");
            if(RS!=null && RS.first()){
                RS.beforeFirst();
                classes.GetNXT NXT=new classes.GetNXT(this.CR.getValues()[2]+"nxt?");
                while(RS.next()){
                    NXT.openURL(RS.getString("nxt1"), "1");
                    NXT.openURL(RS.getString("nxt2"), "2");
                    NXT.openURL(RS.getString("nxt3"), "3");
                    NXT.openURL(RS.getString("nxt4"), "4");
                }
                this.Transactions=NXT.getArray();
                return this.Transactions.length;
            }
        } catch (SQLException ex) {
        }
        return 0;
}
private int getRefunds(){
    java.util.List<String[]> List = new java.util.ArrayList<>();
            int index=0;
        for (String[] Transaction : this.Transactions) {
            if(Transaction[4].equals("nxt")){    //If it is the choosen currency
                    if(Transaction[6].equals("false") || Integer.parseInt(Transaction[2])/100000000<2) List.add(Transaction); //If sender not in db or value less than 1
            }
        }
        String[][] Full=new String[List.size()][6];
        for(int i=0; i<List.size(); i++){
            Full[i]=List.get(i);
        }
        this.Transactions=Full;
        return this.Transactions.length;
}
private void setTable(){
    javax.swing.table.DefaultTableModel list = new javax.swing.table.DefaultTableModel(new Object[][]{},new String [] {"ID","Start", "End", "Period","Refunded"}){
                        @Override
                        public boolean isCellEditable(int row, int column){return false;}; //dont allow the table column editing
                        
                    };
    java.sql.ResultSet RS=null;    
    try {
        RS=this.SQL.PreparedSelect("session", new String[]{"SID","start","end","changeperiod","refunded"},"","","`refunded`,`SID`");
        if(RS.first()){
            RS.beforeFirst();
            while (RS.next()) {
                this.jSessionBox.addItem("ID:"+RS.getString("SID")+" "+RS.getString("start")+"-"+RS.getString("end")+" Refunded: "+RS.getString("refunded"));
                list.addRow(
                    new Object[]{RS.getString("SID"),
                                 RS.getString("start"),
                                 RS.getString("end"),
                                 RS.getString("changeperiod"),
                                 RS.getString("refunded")
                    });
            }
        }
        } catch (SQLException ex) {
            
        }finally{
            org.apache.commons.dbutils.DbUtils.closeQuietly(RS);
        }
    jRefundedTable.setModel(list);
}
private boolean refundSingle(String Phrase, String AmountNQT, String Recipient){
        try {
            /*http://localhost:7876/nxt?
            requestType=sendMoney&
            secretPhrase=IWontTellYou&
            recipient=NXT-4VNQ-RWZC-4WWQ-GVM8S&
            amountNQT=100000000&
            feeNQT=100000000&
            deadline=60*/
            java.net.URL url = new java.net.URL(this.CR.getValues()[4]+"nxt");
            java.util.Map<String,Object> params = new java.util.LinkedHashMap<>();
            params.put("requestType", "sendMoney");
            params.put("secretPhrase", Phrase);
            params.put("recipient", Recipient);
            params.put("amountNQT", AmountNQT);
            params.put("feeNQT", "100000000");
            params.put("deadline", "60");
            StringBuilder postData = new StringBuilder();
            for (java.util.Map.Entry<String,Object> param : params.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(java.net.URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(java.net.URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            
            java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                //System.out.println(line);
            }
            org.json.JSONObject json= new org.json.JSONObject(sb.toString());
            if(json.isNull("errorCode")){
                sb.toString();
                System.out.println("no errorcode");
                return true;
            }else{
                if(!json.isNull("errorDescription")){
                    this.jResp.setText(json.getString("errorDescription"));
                }
                return false;
            }
        } catch (UnsupportedEncodingException | MalformedURLException ex) {
            //Logger.getLogger(Refund.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | JSONException ex) {
            //Logger.getLogger(Refund.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jPhraseField;
    private javax.swing.JButton jRefundButton;
    private javax.swing.JTable jRefundedTable;
    private javax.swing.JLabel jResp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jSessionBox;
    // End of variables declaration//GEN-END:variables
}