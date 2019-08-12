package shopx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DList {

    private final ObjectProperty<Integer> sn = new SimpleObjectProperty<>();
    private final ObjectProperty<Integer> code = new SimpleObjectProperty<>();
    private final StringProperty Description = new SimpleStringProperty();
    private final ObjectProperty<Integer> availableStock = new SimpleObjectProperty<>();
    private final StringProperty price = new SimpleStringProperty();
    private final StringProperty expiryDate = new SimpleStringProperty();

    public DList() {
    }

    public DList(Integer sn, Integer code, String Description, Integer availableStock, String price, String expiryDate) {
        this.sn.set(sn);
        this.code.set(code);
        this.Description.set(Description);
        this.availableStock.set(availableStock);
        this.price.set(price);
        this.expiryDate.set(expiryDate);
    }
    public Integer getSn() {
        return sn.get();
    }

    public ObjectProperty<Integer> snProperty() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn.set(sn);
    }

    public Integer getCode() {
        return code.get();
    }

    public ObjectProperty<Integer> codeProperty() {
        return code;
    }

    public void setCode(Integer code) {
        this.code.set(code);
    }

    public String getDescription() {
        return Description.get();
    }

    public StringProperty descriptionProperty() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description.set(description);
    }

    public Integer getAvailableStock() {
        return availableStock.get();
    }

    public ObjectProperty<Integer> availableStockProperty() {
        return availableStock;
    }

    public void setAvailableStock(Integer availableStock) {
        this.availableStock.set(availableStock);
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getExpiryDate() {
        return expiryDate.get();
    }

    public StringProperty expiryDateProperty() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate.set(expiryDate);
    }

}
