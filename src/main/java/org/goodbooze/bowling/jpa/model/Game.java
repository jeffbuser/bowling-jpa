package org.goodbooze.bowling.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the game database table.
 * 
 */
@Entity
@NamedQuery(name="Game.findAll", query="SELECT g FROM Game g")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="GAME_ID")
	private int gameId;

	@Column(name="GAME_TYPE")
	private String gameType;

	private int score;

	//bi-directional many-to-one association to Frame
	@OneToMany(mappedBy="game")
	private List<Frame> frames;

	//bi-directional many-to-one association to Bowler
	@ManyToOne
	@JoinColumn(name="BOWLER_ID")
	private Bowler bowler;

	public Game() {
	}

	public int getGameId() {
		return this.gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getGameType() {
		return this.gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Frame> getFrames() {
		return this.frames;
	}

	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}

	public Frame addFrame(Frame frame) {
		getFrames().add(frame);
		frame.setGame(this);

		return frame;
	}

	public Frame removeFrame(Frame frame) {
		getFrames().remove(frame);
		frame.setGame(null);

		return frame;
	}

	public Bowler getBowler() {
		return this.bowler;
	}

	public void setBowler(Bowler bowler) {
		this.bowler = bowler;
	}

}