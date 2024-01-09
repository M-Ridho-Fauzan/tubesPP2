/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service.TableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ridho
 */
public class WasteAllUsersTableModel extends AbstractTableModel {

    private List<Object[]> data;
    private String[] columnNames = {"User Name", "Email User", "Telepone", "Daerah", "point", "Kurir"};

    public WasteAllUsersTableModel(List<Object[]> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }
//        @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        if (columnIndex == 0) { // Jika ini kolom ID
//            Object idValue = data.get(rowIndex)[columnIndex];
//            if (idValue instanceof Number) {
//                return ((Number) idValue).intValue();
//            } else {
//                // Handled based on your specific needs
//                return 0; // Misalnya, mengembalikan nilai default jika bukan angka
//            }
//        } else {
//            return data.get(rowIndex)[columnIndex];
//        }
//    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
