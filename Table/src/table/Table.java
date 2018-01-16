package table;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



/**
 *
 * @author dmitry
 */
public class Table extends javax.swing.JFrame {

    private String filename = "table";

    /**
     * Creates new form NewJFrame
     * @param login
     */
    public Table(String login) {
        initComponents();
        calcTable();
        filename = login + "_" + filename;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnChangeUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setAutoCreateRowSorter(true);
        table.setModel(Constants.getTableModel());
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        btnSave.setText("Save");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        btnOpen.setText("Open");
        btnOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOpenMouseClicked(evt);
            }
        });

        btnChangeUser.setText("Change User");
        btnChangeUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOpen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnChangeUser)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnOpen)
                    .addComponent(btnChangeUser))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
        if (evt.getKeyCode() == 10) {
            /*нажатие Enter*/
            calcTable();
        }
        if (evt.getKeyCode() == 127) {
            /*нажатие del*/
            table.setValueAt(null, table.getSelectedRow(), table.getSelectedColumn());
        }
    }//GEN-LAST:event_tableKeyPressed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        calcTable();
    }//GEN-LAST:event_tableMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if (!Logins.getCurrentLogin().equals("")) {
            try {
                FileOutputStream fos = new FileOutputStream(filename);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                TableModel model = table.getModel();
                table.setModel(new DefaultTableModel());
                oos.writeObject(model);
                table.setModel(model);
                oos.close();
                fos.close();
            } catch (FileNotFoundException ex) {
                System.out.println("FileNotFoundException");
            } catch (IOException ex) {
                System.out.println("IOException");
            }
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnOpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpenMouseClicked
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(filename);
            ois = new ObjectInputStream(fis);
            TableModel model = (TableModel) ois.readObject();
            table.setModel(model);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found");
        } catch (IOException ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnOpenMouseClicked

    private void btnChangeUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeUserActionPerformed
        Logins.setCurrentLogin(null);
        this.dispose();
        Run.start();
    }//GEN-LAST:event_btnChangeUserActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeUser;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    private void calcTable() {
        boolean isChange = false;
        /*рассчет ячеек*/
        int x = 0;
//        System.out.println("PG: " + table.getValueAt(1, 1));
        /*первая строка*/
        for (int i = 1; i < 14; i++) {
            x = 0;
            for (int j = 1; j < 7; j++) {
                x += getFromTable(j, i);
            }
            if (isChange(x, 0, i)) {
                isChange = true;
            }
        }

        /*
        строки 2 - 6
         */
        for (int i = 1; i < 7; i++) {
            x = 0;
            for (int j = 2; j < 14; j++) {
                x += getFromTable(i, j);
            }
            if (isChange(x, i, 1)) {
                isChange = true;
            }
//            table.setValueAt(x, i, 1);
        }

        /**/
        if (!String.valueOf(table.getValueAt(7, 1)).equals("")) {
            table.setValueAt("", 7, 1);
        }

        x = getFromTable(0, 13) - getFromTable(9, 13);
        if (isChange(x, 7, 2)) {
            isChange = true;
        }
//        isChange = isChange(x, 7, 2);
//        table.setValueAt(x, 7, 2);

        for (int i = 3; i < 14; i++) {
            x = getFromTable(0, i - 1) - getFromTable(9, i - 1);
            if (isChange(x, 7, i)) {
                isChange = true;
            }
//            table.setValueAt(x, 7, i);
        }

        /**/
        if (!String.valueOf(table.getValueAt(8, 1)).equals("")) {
            table.setValueAt("", 8, 1);
        }
        for (int i = 2; i < 14; i++) {
            x = getFromTable(0, i) - getFromTable(9, i);
            if (isChange(x, 8, i)) {
                isChange = true;
            }
//            table.setValueAt(x, 8, i);
        }

        /**/
        for (int i = 1; i < 14; i++) {
            x = getFromTable(10, i) + getFromTable(15, i) + getFromTable(18, i);
            if (isChange(x, 9, i)) {
                isChange = true;
            }
//            table.setValueAt(x, 9, i);

            x = 0;
            for (int j = 11; j < 15; j++) {
                x += getFromTable(j, i);
            }
            if (isChange(x, 10, i)) {
                isChange = true;
            }
//            table.setValueAt(x, 10, i);

            x = 0;
            for (int j = 16; j < 18; j++) {
                x += getFromTable(j, i);
            }
            if (isChange(x, 15, i)) {
                isChange = true;
            }
//            table.setValueAt(x, 15, i);

            x = 0;
            for (int j = 19; j < 25; j++) {
                x += getFromTable(j, i);
            }
            if (isChange(x, 18, i)) {
                isChange = true;
            }
//            table.setValueAt(x, 18, i);
        }

        for (int i = 11; i < 15; i++) {
            x = 0;
            for (int j = 2; j < 14; j++) {
                x += getFromTable(i, j);
            }
            if (isChange(x, i, 1)) {
                isChange = true;
            }
//            table.setValueAt(x, i, 1);
        }
        for (int i = 16; i < 18; i++) {
            x = 0;
            for (int j = 2; j < 14; j++) {
                x += getFromTable(i, j);
            }
            if (isChange(x, i, 1)) {
                isChange = true;
            }
//            table.setValueAt(x, i, 1);
        }
        for (int i = 19; i < 25; i++) {
            x = 0;
            for (int j = 2; j < 14; j++) {
                x += getFromTable(i, j);
            }
            if (isChange(x, i, 1)) {
                isChange = true;
            }
//            table.setValueAt(x, i, 1);
        }
        /*рассчет ячеек закончен*/
        if (isChange) {
            calcTable();
        }
//        new MyTable().setTableModel(getTableModel());
    }

    private int getFromTable(int col, int raw) {
        try {
            return Integer.parseInt(String.valueOf(table.getValueAt(col, raw)));
        } catch (NumberFormatException nfe) {
            return 0;
        } catch (java.lang.ClassCastException castException) {
            return 0;
        }
    }

    private boolean isChange(int x, int col, int raw) {
        if (getFromTable(col, raw) != x) {
            table.setValueAt(x, col, raw);
            return true;
        }
        return false;
    }

}