/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nnpcgroup.onboarding.ejb;

import com.nnpcgroup.onboarding.entity.BasicPay;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 18359
 */
@Stateless
public class BasicPayFacade extends AbstractFacade<BasicPay> {
    @PersistenceContext(unitName = "OnboardingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BasicPayFacade() {
        super(BasicPay.class);
    }
    
}
