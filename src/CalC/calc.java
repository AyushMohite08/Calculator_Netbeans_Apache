/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package CalC;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.awt.event.*;

/**
 *
 * @author ayush
 */
public class calc extends javax.swing.JPanel {

    /**
     * Creates new form calc
     */
    public calc() {
        setFocusable(true); // Allow the panel to capture key events
        setFocusTraversalKeysEnabled(false);  // Disable focus traversal keys
        requestFocusInWindow();  // Ensure the panel has focus when displayed
        
        initComponents();
        
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                char keyChar = e.getKeyChar();
                if(isCalculatorOn)
                {
                    if(Character.isDigit(keyChar) || "+-*/%.".indexOf(keyChar)>=0) {
                        upDate(String.valueOf(keyChar));
                    } else if(keyChar == KeyEvent.VK_BACK_SPACE) {
                        upDate("Back");
                    } else if(keyChar == KeyEvent.VK_ENTER) {
                        upDate("Ans");
                    } else if(keyChar == KeyEvent.VK_ESCAPE) {
                        upDate("Clc");
                    }
                }
            }
        });
    }
    
    public calc(javax.swing.JLabel jLabel1)
    {
        this.jLabel1=jLabel1;
        jLabel1.setText("CALCULATOR");
    }

    public void upDate(String command){
        
        if(!isCalculatorOn)
        {
            if(command.equals("ON/OFF"))
            {
                isCalculatorOn = true;
                jLabel1.setText("0");
                currentInput.setLength(0);   //clears input
            }
            else
            {
                jLabel1.setText("CALCULATOR");
            }
            return;
        }
        
        if(command.equals("ON/OFF"))
        {
            isCalculatorOn = false;
            jLabel1.setText("CALCULATOR");
            currentInput.setLength(0);
            return;
        }
        
        if(command.equals("Clc"))
        {
            currentInput.setLength(0);
            jLabel1.setText("0");
            return;
        }
        
        if(command.equals("Back"))
        {
            if(currentInput.length()>0)
            {
                currentInput.deleteCharAt(currentInput.length()-1);
                jLabel1.setText(currentInput.length()>0 ? currentInput.toString() : "0");
            }
            return;
        }
        
        if ("0123456789.".contains(command)) 
        {
            if(".".equals(command))
            {
                //to check if there is an operator before decimal point it will append 0 to the string
                if("+-*/%".contains(String.valueOf(currentInput.charAt(currentInput.length()-1))))
                    currentInput.append("0");
                if('.'!=currentInput.charAt(currentInput.length()-1))// checks if "." doesn't get inputed multiple times
                {
                    currentInput.append(command);
                    jLabel1.setText(currentInput.toString());
                }
            } 
            else
            {
                currentInput.append(command);
                jLabel1.setText(currentInput.toString());
            }
        } 
        else if ("+-*/%".contains(command)) 
        {
            if(currentInput.charAt(currentInput.length()-1) == '.')
                currentInput.setLength(currentInput.length()-1);
            
            // Check if the last character is already an operator
            if (currentInput.length() > 0 && "+-*/%".contains(String.valueOf(currentInput.charAt(currentInput.length() - 1)))) 
            {
                // Replace the last operator with the new one
                currentInput.setCharAt(currentInput.length() - 1, command.charAt(0));
            } 
            else 
            {
                currentInput.append(command);
            }
            jLabel1.setText(currentInput.toString());
        }
        else if("Ans".equals(command))
        {
            try
            {
                double result = evaluateExpression(currentInput.toString());
                jLabel1.setText(String.valueOf(result));
                currentInput.setLength(0); // clear for new input
            }
            catch(Exception ex)
            {
                jLabel1.setText("ERROR");
                currentInput.setLength(0);
                System.out.println(ex);
            }
        }
    }
    
    private double evaluateExpression(String expression) throws Exception 
    {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        Object result = engine.eval(expression);
    
        // Convert the result to double
        if (result instanceof Number) 
        {
            return ((Number) result).doubleValue();
        } 
        else 
        {
            throw new Exception("Invalid calculation result");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(400, 500));
        setPreferredSize(new java.awt.Dimension(400, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(51, 204, 0));
        jLabel1.setFont(new java.awt.Font("Courier New", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setLabelFor(this);
        jLabel1.setText("CALCULATOR");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.setOpaque(true);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 23, 364, 76));
        jLabel1.getAccessibleContext().setAccessibleDescription("");

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton1.setText("<html> <div> <p>ON/</p> </div> <div> <p>OFF</p> </div> </htm.>");
        jButton1.setBorder(null);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setRequestFocusEnabled(false);
        jButton1.setRolloverEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 117, 66, 66));

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton3.setText("-");
        jButton3.setBorder(null);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setRequestFocusEnabled(false);
        jButton3.setRolloverEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 339, 60, 60));

        jButton4.setBackground(new java.awt.Color(102, 102, 102));
        jButton4.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton4.setText("/");
        jButton4.setBorder(null);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setRequestFocusEnabled(false);
        jButton4.setRolloverEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 267, 60, 60));

        jButton5.setBackground(new java.awt.Color(102, 102, 102));
        jButton5.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton5.setText("%");
        jButton5.setBorder(null);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setRequestFocusEnabled(false);
        jButton5.setRolloverEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 195, 60, 60));

        jButton6.setBackground(new java.awt.Color(102, 102, 102));
        jButton6.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton6.setText("+");
        jButton6.setBorder(null);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setRequestFocusEnabled(false);
        jButton6.setRolloverEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 339, 60, 60));

        jButton7.setBackground(new java.awt.Color(102, 102, 102));
        jButton7.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton7.setText("*");
        jButton7.setBorder(null);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setRequestFocusEnabled(false);
        jButton7.setRolloverEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 267, 60, 60));

        jButton8.setBackground(new java.awt.Color(102, 102, 102));
        jButton8.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton8.setText("1");
        jButton8.setBorder(null);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setRequestFocusEnabled(false);
        jButton8.setRolloverEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 339, 60, 60));

        jButton9.setBackground(new java.awt.Color(102, 102, 102));
        jButton9.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton9.setText("2");
        jButton9.setBorder(null);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setRequestFocusEnabled(false);
        jButton9.setRolloverEnabled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 339, 60, 60));

        jButton10.setBackground(new java.awt.Color(102, 102, 102));
        jButton10.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton10.setText("3");
        jButton10.setBorder(null);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setRequestFocusEnabled(false);
        jButton10.setRolloverEnabled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 339, 60, 60));

        jButton11.setBackground(new java.awt.Color(102, 102, 102));
        jButton11.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton11.setText("4");
        jButton11.setBorder(null);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setRequestFocusEnabled(false);
        jButton11.setRolloverEnabled(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 267, 60, 60));

        jButton12.setBackground(new java.awt.Color(102, 102, 102));
        jButton12.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton12.setText("5");
        jButton12.setBorder(null);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setRequestFocusEnabled(false);
        jButton12.setRolloverEnabled(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 267, 60, 60));

        jButton13.setBackground(new java.awt.Color(102, 102, 102));
        jButton13.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton13.setText("6");
        jButton13.setBorder(null);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setRequestFocusEnabled(false);
        jButton13.setRolloverEnabled(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 267, 60, 60));

        jButton14.setBackground(new java.awt.Color(102, 102, 102));
        jButton14.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton14.setText("7");
        jButton14.setBorder(null);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setRequestFocusEnabled(false);
        jButton14.setRolloverEnabled(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 195, 60, 60));

        jButton15.setBackground(new java.awt.Color(102, 102, 102));
        jButton15.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton15.setText("8");
        jButton15.setBorder(null);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setRequestFocusEnabled(false);
        jButton15.setRolloverEnabled(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 195, 60, 60));

        jButton16.setBackground(new java.awt.Color(102, 102, 102));
        jButton16.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton16.setText("9");
        jButton16.setBorder(null);
        jButton16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton16.setRequestFocusEnabled(false);
        jButton16.setRolloverEnabled(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 195, 60, 60));

        jButton17.setBackground(new java.awt.Color(102, 102, 102));
        jButton17.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton17.setText("0");
        jButton17.setBorder(null);
        jButton17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton17.setRequestFocusEnabled(false);
        jButton17.setRolloverEnabled(false);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 60, 60));

        jButton18.setBackground(new java.awt.Color(102, 102, 102));
        jButton18.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton18.setText("Ans");
        jButton18.setBorder(null);
        jButton18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton18.setRequestFocusEnabled(false);
        jButton18.setRolloverEnabled(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 411, 100, 60));

        jButton19.setBackground(new java.awt.Color(102, 102, 102));
        jButton19.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton19.setText("Clc");
        jButton19.setBorder(null);
        jButton19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton19.setRequestFocusEnabled(false);
        jButton19.setRolloverEnabled(false);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 100, 60));

        jButton20.setBackground(new java.awt.Color(102, 102, 102));
        jButton20.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton20.setText("Back");
        jButton20.setBorder(null);
        jButton20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton20.setRequestFocusEnabled(false);
        jButton20.setRolloverEnabled(false);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 411, 90, 60));

        jLabel2.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html> <div> <p>PROGRAMMER'S</p> </div> <div> <p>Calculator</p> </div> </html>");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("DialogInput", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Modulus");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 201, 57, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CalC/image.png"))); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 20, 20));

        jButton21.setBackground(new java.awt.Color(102, 102, 102));
        jButton21.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        jButton21.setText(".");
        jButton21.setBorder(null);
        jButton21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton21.setRequestFocusEnabled(false);
        jButton21.setRolloverEnabled(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 60, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setActionCommand("ON/OFF");
        upDate(evt.getActionCommand());
// TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton3.setActionCommand("-");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jButton4.setActionCommand("/");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jButton5.setActionCommand("%");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jButton6.setActionCommand("+");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jButton7.setActionCommand("*");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jButton8.setActionCommand("1");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jButton9.setActionCommand("2");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jButton10.setActionCommand("3");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        jButton11.setActionCommand("4");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        jButton12.setActionCommand("5");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        jButton13.setActionCommand("6");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        jButton14.setActionCommand("7");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        jButton15.setActionCommand("8");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        jButton16.setActionCommand("9");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        jButton17.setActionCommand("0");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        jButton18.setActionCommand("Ans");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        jButton19.setActionCommand("Clc");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        jButton20.setActionCommand("Back");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        jButton21.setActionCommand(".");
        upDate(evt.getActionCommand());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
    private boolean isCalculatorOn = false;
    private StringBuilder currentInput = new StringBuilder();
}
