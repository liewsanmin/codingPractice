/*
You left your computer unlocked and your friend decided to troll you by copying
 a lot of your files to random spots all over your file system.
Even worse, she saved the duplicate files with random, embarrassing names
("this_is_like_a_digital_wedgie.txt" was clever, I'll give her that).

Write a function that returns a list of all the duplicate files. We'll check
 them by hand before actually deleting them, since programmatically deleting
  files is really scary. To help us confirm that two files are actually
   duplicates, return a list of FilePaths objects with variables for the
    original and duplicate paths:

    For example:

  [(duplicate: /tmp/parker_is_dumb.mpg, original:
   /home/parker/secret_puppy_dance.mpg),
(duplicate: /home/trololol.mov, original: /etc/apache2/httpd.conf)]
You can assume each file was only duplicated once.s

O(n) time and space
*/
public static class FilePaths{
    private Path duplicatePath;
    private Path  originalPath;

    public FilePaths(Path duplicatePath, Path originalPath){
        this.duplicatePath = duplicatePath;
        this.originalPath = originalPath;
    }

    public Path getDuplicatePath(){
        return duplicatePath;
    }

    public Path getOriginalPath(){
        return originalPath;
    }

    public String toString(){
        return String.format("(duplicate: %s, original: %s)", duplicatePath, originalPath);
    }
}

private static class FileInfo{
    long timeLastEdited;
    Path path;

    FileInfo(long timeLastEdited, Path path){
        this.timeLastEdited = timeLastEdited;
        this.path = path;
    }
}

public static List<FilePaths> findDuplicateFiles(Path startingDirectory){
    Map<String, FileInfo> filesSeenAlready = new HashMap<>();
    Stack<Path> stack = new Stack<>();
    stack.push(startingDirectory);

    List<FilePaths> duplicates = new ArrayList<>();

    while(!stack.empty()){
        Path currentPath = stack.pop();
        File currentFile = new File(currentPath.toString());

        if(currentFile.isDirectory()){
            for(File file : currentFile.listFiles()){
                stack.add(file.toPath());
            }
        } else {
            String fileHash;
            try{
                fileHash = sampleHashFile(currentPath);
            } catch (IOException e){
                e.printStackTrace();
                continue;
            } catch (NoSuchAlgorithmException e){
                e.printStackTrace();
                continue;
            }
            long currentLastEditedTime = currentFile.lastModified();

            if(filesSeenAlready.containsKey(fileHash)){
                FileInfo fileInfo = filesSeenAlready.get(filehash);
                long existingLastEditedTime = fileInfo.timeLastEdited;
                Path existingPath - fileInfo.path;

                if(currentLastEditedTime > existingLastEditedTime){
                    duplicates.add(new FilePaths(currentPath, existingPath));
                } else {
                    duplicates.add(new FilePaths(existingPath, currentPath));
                    filesSeenAlready.put(fileHash, new FileInfo(currentLastEditedTime, currentPath));
                } else {
                    filesSeenAlready.put(fileHash, new FileInfo(currentLastEditedTime, currentPath));
                }
            }
        }
        return duplicates;
    }
}
    private static final int SAMPLE_SIZE = 4000;

    private static String sampleHashFile(Path path) throws IOException, NoSuchAlgorithmException{
        final long totalBytes = new File(path.toString()).length();
        try(InputStream inputStream = new FileInputStream(path.toString())){
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            DigestInputStream digestInputStream = new DigestInputStream(inputStream, digest);

            if(totalBytes < SAMPLE_SIZE * 3){
                byte[] bytes new byte[(int) totalBytes];
                digestInputStream.read(bytes);
            } else {
                byte[] bytes = new byte[SAMPLE_SIZE * 3];
                long numBytesBetweenSamples = (totalBytes - SAMPLE_SIZE * 3) / 2;

                for(int n = 0; n < 3; n++){
                    digestInputStream.read(bytes, n * SAMPLE_SIZE, SAMPLE_SIZE);
                    digestInputStream.skip(numBytesBetweenSamples);
                }
            }
            return new BigInteger(1, digest.digest()).toString(16);
        }
    }
