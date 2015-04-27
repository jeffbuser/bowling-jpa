package org.goodbooze.bowling.jpa.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the frame database table.
 * 
 */
@Entity
@NamedQuery(name="Frame.findAll", query="SELECT f FROM Frame f")
public class Frame implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FRAME_ID")
	private int frameId;

	@Column(name="FILL_BALL")
	private int fillBall;

	@Column(name="FIRST_BALL")
	private int firstBall;

	@Column(name="FRAME_INDEX")
	private int frameIndex;

	@Column(name="SECOND_BALL")
	private int secondBall;

	//bi-directional many-to-one association to Game
	@ManyToOne
	@JoinColumn(name="GAME_ID")
	private Game game;

	public Frame() {
	}

	public int getFrameId() {
		return this.frameId;
	}

	public void setFrameId(int frameId) {
		this.frameId = frameId;
	}

	public int getFillBall() {
		return this.fillBall;
	}

	public void setFillBall(int fillBall) {
		this.fillBall = fillBall;
	}

	public int getFirstBall() {
		return this.firstBall;
	}

	public void setFirstBall(int firstBall) {
		this.firstBall = firstBall;
	}

	public int getFrameIndex() {
		return this.frameIndex;
	}

	public void setFrameIndex(int frameIndex) {
		this.frameIndex = frameIndex;
	}

	public int getSecondBall() {
		return this.secondBall;
	}

	public void setSecondBall(int secondBall) {
		this.secondBall = secondBall;
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}