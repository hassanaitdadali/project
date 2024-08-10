package com.sportreservation.optimisationdeslivraison.Service;

import com.sportreservation.optimisationdeslivraison.Entities.Partner;
import com.sportreservation.optimisationdeslivraison.Repositories.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpectralClusteringService {
/*

    @Autowired
    private PartnerRepository livraisonPointRepository;

    public List<List<Partner>> applySpectralClustering(int k) {
        List<Partner> points = PartnerRepository.findPartnerByLatitudeAfterAndLongitude();

        // Dummy clustering logic
        List<List<Partner>> clusters = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            clusters.add(new ArrayList<>());
        }
        for (int i = 0; i < points.size(); i++) {
            clusters.get(i % k).add(points.get(i));
        }
        return clusters;
    }

*/


















//    @Autowired
//    private PartnerRepository livraisonPointRepository;
//
//    public List<Partner> getAllLivraisonPoints() {
//        return livraisonPointRepository.findAll();
//    }
//
//    public List<List<Partner>> applySpectralClustering(int k) {
//        List<Partner> points = getAllLivraisonPoints();
//        int numPoints = points.size();
//
//        // Create adjacency matrix
//        RealMatrix adjacencyMatrix = new Array2DRowRealMatrix(numPoints, numPoints);
//        for (int i = 0; i < numPoints; i++) {
//            for (int j = 0; j < numPoints; j++) {
//                double distance = euclideanDistance(points.get(i), points.get(j));
//                adjacencyMatrix.setEntry(i, j, Math.exp(-distance));
//            }
//        }
//
//        // Create degree matrix
//        RealMatrix degreeMatrix = new Array2DRowRealMatrix(numPoints, numPoints);
//        for (int i = 0; i < numPoints; i++) {
//            double sum = 0;
//            for (int j = 0; j < numPoints; j++) {
//                sum += adjacencyMatrix.getEntry(i, j);
//            }
//            degreeMatrix.setEntry(i, i, sum);
//        }
//
//        // Create Laplacian matrix
//        RealMatrix laplacianMatrix = degreeMatrix.subtract(adjacencyMatrix);
//
//        // Compute the first k eigenvectors of the Laplacian matrix
//        EigenDecomposition eigenDecomposition = new EigenDecomposition(laplacianMatrix);
//        RealMatrix eigenvectors = eigenDecomposition.getV().getSubMatrix(0, numPoints - 1, 0, k - 1);
//
//        // Perform k-means clustering on the eigenvectors
//        List<List<Partner>> clusters = kMeansClustering(eigenvectors, points, k);
//
//        return clusters;
//    }
//
//    private double euclideanDistance(Partner p1, Partner p2) {
//        double latDiff = p1.getLatitude() - p2.getLatitude();
//        double lonDiff = p1.getLongitude() - p2.getLongitude();
//        return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff);
//    }
//
//    private List<List<Partner>> kMeansClustering(RealMatrix data, List<Partner> points, int k) {
//        // Implement k-means clustering on the data
//        // Return a list of clusters, where each cluster is a list of Partner objects
//        // Placeholder implementation
//        List<List<Partner>> clusters = new ArrayList<>();
//        for (int i = 0; i < k; i++) {
//            clusters.add(new ArrayList<>());
//        }
//
//        // Assign points to clusters (dummy assignment)
//        for (int i = 0; i < points.size(); i++) {
//            clusters.get(i % k).add(points.get(i));
//        }
//
//        return clusters;
//    }











//    @Autowired
//    private PartnerRepository PartnerRepository;
//
//    public String performSpectralClustering(int k) {
//        List<Partner> points = PartnerRepository.findAll();
//
//        // Step 1: Construct the similarity matrix
//        RealMatrix similarityMatrix = constructSimilarityMatrix(points);
//
//        // Step 2: Compute the Laplacian matrix
//        RealMatrix laplacianMatrix = computeLaplacianMatrix(similarityMatrix);
//
//        // Step 3: Compute the eigenvalues and eigenvectors
//        EigenDecomposition eigenDecomposition = new EigenDecomposition(laplacianMatrix);
//        RealMatrix eigenVectors = eigenDecomposition.getV();
//
//        // Step 4: Form the feature matrix
//        RealMatrix featureMatrix = eigenVectors.getSubMatrix(0, points.size() - 1, 0, k - 1);
//
//        // Step 5: Apply k-means clustering
//        // Use a simple k-means clustering algorithm on the feature matrix
//
//        // Return the clustering results (for simplicity, return a string representation)
//        return featureMatrix.toString();
//    }
//
//    private RealMatrix constructSimilarityMatrix(List<Partner> points) {
//        int n = points.size();
//        RealMatrix similarityMatrix = new BlockRealMatrix(n, n);
//        double sigma = 1.0;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                double distance = calculateDistance(points.get(i), points.get(j));
//                double similarity = Math.exp(-distance * distance / (2 * sigma * sigma));
//                similarityMatrix.setEntry(i, j, similarity);
//            }
//        }
//        return similarityMatrix;
//    }
//
//    private double calculateDistance(Partner p1,Partner p2) {
//        double deltaX = p1.getLatitude() - p2.getLatitude();
//        double deltaY = p1.getLongitude() - p2.getLongitude();
//        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
//    }
//
//    private RealMatrix computeLaplacianMatrix(RealMatrix similarityMatrix) {
//        int n = similarityMatrix.getRowDimension();
//        RealMatrix degreeMatrix = new BlockRealMatrix(n, n);
//
//        for (int i = 0; i < n; i++) {
//            double sum = 0;
//            for (int j = 0; j < n; j++) {
//                sum += similarityMatrix.getEntry(i, j);
//            }
//            degreeMatrix.setEntry(i, i, sum);
//        }
//
//        RealMatrix laplacianMatrix = degreeMatrix.subtract(similarityMatrix);
//        return laplacianMatrix;
//    }
}
