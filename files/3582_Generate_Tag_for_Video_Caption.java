class Solution {
    public String generateTag(String caption) {
        String[] words = caption.trim().split("\\s+");
        StringBuilder tag = new StringBuilder("#");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) continue;

            word = word.replaceAll("[^a-zA-Z]", ""); // remove non-letter characters
            if (word.isEmpty()) continue;

            if (i == 0) {
                tag.append(word.toLowerCase());
            } else {
                tag.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    tag.append(word.substring(1).toLowerCase());
                }
            }
        }

        // Remove any non-letter characters except first #
        String result = tag.toString().charAt(0) + tag.toString().substring(1).replaceAll("[^a-zA-Z]", "");

        // Truncate to 100 characters
        if (result.length() > 100) {
            result = result.substring(0, 100);
        }

        return result;
    }
}

