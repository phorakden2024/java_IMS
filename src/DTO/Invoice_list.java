/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
import java.util.Date;
/**
 *
 * @author Da Phadenphorakden
 */
public class Invoice_list {
    private Integer invoice_id;
    private Date invoice_date;
    private Double total_amount;

    public Invoice_list(Integer invoice_id, Date invoice_date, Double total_amount) {
        this.invoice_id = invoice_id;
        this.invoice_date = invoice_date;
        this.total_amount = total_amount;
    }

    public Integer getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Integer invoice_id) {
        this.invoice_id = invoice_id;
    }

    public Date getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(Date invoice_date) {
        this.invoice_date = invoice_date;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }
    
}
