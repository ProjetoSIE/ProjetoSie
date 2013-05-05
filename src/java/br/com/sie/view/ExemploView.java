/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sie.view;

import br.com.sie.controller.ExemploController;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author Marcos Costa
 */
@ManagedBean
@ViewScoped
public class ExemploView {
    private final ExemploController controller;

    public ExemploView() {
        controller = new ExemploController();
    }
    
    public void exibir(){
        controller.exibir();
    }
}
