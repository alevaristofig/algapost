package com.postservice.domain.utility;

import java.util.UUID;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedEpochRandomGenerator;

public class IdGenerator {
	
	private static final TimeBasedEpochRandomGenerator timeBasedEpochRandomGenerator =
			Generators.timeBasedEpochRandomGenerator();
	
	private IdGenerator() {}
	
	public static UUID generateTimeBaseUUID() {
		return timeBasedEpochRandomGenerator.generate();
	}

}
