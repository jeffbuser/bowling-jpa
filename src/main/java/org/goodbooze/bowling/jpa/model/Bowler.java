package org.goodbooze.bowling.jpa.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bowler database table.
 * 
 */
@Entity
@NamedQuery(name="Bowler.findAll", query="SELECT b FROM Bowler b")
public class Bowler implements Serializable {
	private static final long serialVersionUID = 1L;

	private double average;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BOWLER_ID")
	private int bowlerId;

	@Column(name="BOWLER_NAME")
	private String bowlerName;

	@Column(name="BOWLER_USBC_NUMBER")
	private String bowlerUsbcNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_MODIFIED")
	private Date lastModified;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="bowler")
	private List<Game> games;

	public Bowler() {
	}

	public double getAverage() {
		return this.average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public String getBowlerName() {
		return this.bowlerName;
	}

	public void setBowlerName(String bowlerName) {
		this.bowlerName = bowlerName;
	}

	public String getBowlerUsbcNumber() {
		return this.bowlerUsbcNumber;
	}

	public void setBowlerUsbcNumber(String bowlerUsbcNumber) {
		this.bowlerUsbcNumber = bowlerUsbcNumber;
	}

	public Date getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public List<Game> getGames() {
		return this.games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Game addGame(Game game) {
		getGames().add(game);
		game.setBowler(this);

		return game;
	}

	public Game removeGame(Game game) {
		getGames().remove(game);
		game.setBowler(null);

		return game;
	}

}