package table;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author dmitry
 */
public class Constants {
    
    public static final String [] COLUMN_IDENTIFIERS = {
        "За год", 
        "Январь", 
        "Февраль", 
        "Март", 
        "Апрель", 
        "Май", 
        "Июнь", 
        "Июль", 
        "Август", 
        "Сентябрь", 
        "Октябрь", 
        "Ноябрь", 
        "Декабрь"};
    public static final String [] FIRST_COLUMN = { 
        "Общий доход",
        "З/П",
        "Аванс",
        "Отпускные",
        "Доп. заработок",
        "Пособия",
        "Резерв",
        "Ост. пред. мес.",
        "Кошелек",
        "Общий расход",
        "Комунальные",
        "Вода",
        "Электричество",
        "Телефон",
        "Интернет",
        "Машина",
        "Ремонт",
        "Бензин",
        "Общие затраты",
        "Хоз. товары",
        "Питание",
        "Оплата дет.сад",
        "Оплата школа",
        "Обувь",
        "Одежда"    
    };
    public static TableModel getTableModel(){
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("", FIRST_COLUMN);
        for (int i =0; i< COLUMN_IDENTIFIERS.length; i++){
            defaultTableModel.addColumn(COLUMN_IDENTIFIERS[i]);
        }  
        return defaultTableModel;
    }
    
    
    
}
