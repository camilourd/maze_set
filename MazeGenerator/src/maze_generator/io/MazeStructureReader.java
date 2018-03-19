package maze_generator.io;

import java.io.IOException;

import maze_generator.maze.MazeStructure;
import unalcol.io.ShortTermMemoryReader;
import unalcol.types.collection.bitarray.BitArray;

public class MazeStructureReader {
	
	public final static int SPACE = ' ';
	public final static int ZERO = '0';
	public final static int EOF = -1;
	
	public static MazeStructure read(ShortTermMemoryReader reader) throws IOException {
		int xsize = readNumber(reader), ysize = readNumber(reader);
		MazeStructure structure = new MazeStructure(xsize, ysize);
		for(int y = 0; y < ysize; y++)
			for(int x = 0; x < xsize; x++)
				structure.data[y][x] = readNumber(reader);
		return structure;
	}
	
	public static int readNumber(ShortTermMemoryReader reader) throws IOException {
		int number = 0;
		for(int c = reader.read(); c > EOF && c != SPACE; c = reader.read())
			number = (number * 10) + c - ZERO;
		return number;
	}
	
	public static BitArray readBitArray(ShortTermMemoryReader reader) throws IOException {
		BitArray bit = new BitArray("");
		for(int c = reader.read(); c > EOF && c != SPACE; c = reader.read())
			bit.add(c > ZERO);
		return bit;
	}
}
