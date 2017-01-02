package org.wildfly.jiras.issue7841;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class MyEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
}
