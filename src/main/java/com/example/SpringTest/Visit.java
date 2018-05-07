package com.example.SpringTest;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * Created by PStroganov on 20.02.2018.
 * @author PStroganov
 */

@Entity
public class Visit {

    @Id
    @GeneratedValue
    public Long id;

    public String description;
}
