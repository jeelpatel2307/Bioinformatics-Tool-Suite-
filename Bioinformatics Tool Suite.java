import java.util.HashMap;
import java.util.Map;

public class BioinformaticsToolSuite {

    public static void main(String[] args) {
        String dnaSequence = "ATGCGTACAGCTGACGATCAGCTAGCTAGCT";

        // DNA sequence analysis
        int length = dnaSequence.length();
        int gcContent = calculateGCContent(dnaSequence);
        System.out.println("DNA Sequence Length: " + length);
        System.out.println("GC Content: " + gcContent + "%");

        // DNA transcription
        String rnaSequence = transcribeDNAtoRNA(dnaSequence);
        System.out.println("Transcribed RNA Sequence: " + rnaSequence);

        // DNA translation
        String proteinSequence = translateRNAtoProtein(rnaSequence);
        System.out.println("Translated Protein Sequence: " + proteinSequence);
    }

    // Calculate GC content of a DNA sequence
    public static int calculateGCContent(String sequence) {
        int countGC = 0;
        for (char c : sequence.toCharArray()) {
            if (c == 'G' || c == 'C') {
                countGC++;
            }
        }
        return (int) ((double) countGC / sequence.length() * 100);
    }

    // Transcribe DNA to RNA
    public static String transcribeDNAtoRNA(String dnaSequence) {
        return dnaSequence.replaceAll("T", "U");
    }

    // Translate RNA to Protein
    public static String translateRNAtoProtein(String rnaSequence) {
        Map<String, String> codonTable = new HashMap<>();
        codonTable.put("UUU", "F");
        codonTable.put("UUC", "F");
        // Add more codons as needed...

        StringBuilder proteinSequence = new StringBuilder();
        for (int i = 0; i < rnaSequence.length() - 2; i += 3) {
            String codon = rnaSequence.substring(i, i + 3);
            String aminoAcid = codonTable.get(codon);
            if (aminoAcid != null) {
                proteinSequence.append(aminoAcid);
            } else {
                proteinSequence.append("X"); // Unknown amino acid
            }
        }
        return proteinSequence.toString();
    }
}
