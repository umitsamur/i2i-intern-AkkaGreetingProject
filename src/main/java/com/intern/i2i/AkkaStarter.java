package com.intern.i2i;

import akka.actor.typed.ActorSystem;

import java.io.IOException;

public class AkkaStarter {
	public static void main(String[] args) {
		// #actor-system
		final ActorSystem<GreeterMain.SayHello> actorA = ActorSystem.create(GreeterMain.create(), "Actors");
		
		// #actor-system

		// #main-send-messages
		actorA.tell(new GreeterMain.SayHello("ActorB"));
		// #main-send-messages

		try {
			System.out.println(">>> Press ENTER to exit <<<");
			System.in.read();
		} catch (IOException ignored) {
		} finally {
			actorA.terminate();
		}
	}
}
