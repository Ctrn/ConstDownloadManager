package sequnce;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Static class for reading from a file-sequence stream.

 */
public class FileSequenceReader {
	/**
	 * Returns the data from the next sub-file in the given file sequence stream.
	 * <p>
	 * If no sub-files remain, returns null. If the stream ends prematurely,
	 * throws an EOFException.
	 */
	public static byte[] readOneFile(InputStream sequence) 
		throws IOException, EOFException {
		// sequence files consist of a (4-byte) int giving the size of the sub-file,
		// followed by the sub-file, followed by another size, followed by the sub-file,
		// and so on until EOF
		int sizeOfStreamedSeq = 0;
		 		// note that this hides errors involving less than 4 trailing bytes:
		 		try {
		 			sizeOfStreamedSeq = new DataInputStream(sequence).readInt();
		 		} catch(EOFException e) { // no more sub-files
		 			return null; 
		 		}
		 		byte[] streamData = new byte[sizeOfStreamedSeq];
		 		int readData = 0;
		 		while(readData<sizeOfStreamedSeq) {
		 			int readedStreamData = sequence.read(streamData, readData, sizeOfStreamedSeq-readData);
		 			if(readedStreamData==-1)
		 				throw new EOFException("Stream end @: "+readedStreamData+" Bytes: "+sizeOfStreamedSeq+" -Byte of file!");
		 					readData += readedStreamData;
		 							}
		 		return streamData;
		 	}		 
	}