package com.abaco.entities;

import java.io.Serializable;
import java.util.Locale.Category;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.abaco.util.DataBaseConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = DataBaseConstants.TABLE_PAYMENTS, schema = DataBaseConstants.SCHEMA)
public class PaymentEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "description")
	private String description;

	@Column(name = "period", length = 6)
	@NotNull
	@NotEmpty
	private String period;

	@Column(name = "quantity")
	@NotNull
	@NotEmpty
	private Float quantity;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "payment")
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	@JsonIgnore
	private UserEntity user;

}
