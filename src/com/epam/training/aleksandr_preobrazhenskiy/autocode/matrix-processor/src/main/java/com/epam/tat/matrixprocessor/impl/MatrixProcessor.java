package com.epam.tat.matrixprocessor.impl;

import com.epam.tat.matrixprocessor.IMatrixProcessor;
import com.epam.tat.matrixprocessor.exception.MatrixProcessorException;

import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Function Description:
 * Complete the functions below. All methods must work with matrices of the double type.
 *
 * Constraints:
 * 0 < m < 10
 * 0 < n < 10
 * where m - number of rows in matrix
 * where n - number of columns in matrix
 *
 * In case of incorrect input values or inability to perform a calculation, the method should throw an appropriate
 * exception.
 *
 */
public class MatrixProcessor implements IMatrixProcessor {

	/**
	 * Matrix transpose is an operation on a matrix where its rows become columns with the same numbers.
	 * Ex.:
	 * |1 2|			|1 3 5|
	 * |3 4|   ====>	|2 4 6|
	 * |5 6|
	 *
	 * @param matrix - matrix for transposition
	 * @return the transposed matrix
	 */
	@Override
	public double[][] transpose(double[][] matrix) {
		checkMatrixNonZero(matrix);

		final int rows = matrix.length;
		final int cols = matrix[0].length;

		double[][] transposedMatrix = new double[cols][rows];

		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				transposedMatrix[i][j] = matrix[j][i];
			}
		}
		return transposedMatrix;
	}

	/**
	 * The method flips the matrix clockwise.
	 * Ex.:
	 * * |1 2|			|5 3 1|
	 * * |3 4|   ====>	|6 4 2|
	 * * |5 6|
	 *
	 * @param matrix - rotation matrix
	 * @return rotated matrix
	 */
	@Override
	public double[][] turnClockwise(double[][] matrix) {
		checkMatrixNonZero(matrix);

		final int rows = matrix.length;
		final int cols = matrix[0].length;

		double[][] rotatedMatrix = new double[cols][rows];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				rotatedMatrix[j][rows - i - 1] = matrix[i][j];
			}
		}
		return rotatedMatrix;
	}

	/**
	 * This method multiplies matrix firstMatrix by matrix secondMatrix
	 * <p>
	 * See {https://en.wikipedia.org/wiki/Matrix_multiplication}
	 *
	 * @param firstMatrix  - first matrix to multiply
	 * @param secondMatrix - second matrix to multiply
	 * @return result matrix
	 */
	@Override
	public double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
		checkMatrixNonZero(firstMatrix);
		checkMatrixNonZero(secondMatrix);

		if (firstMatrix[0].length != secondMatrix.length) {	throw new MatrixProcessorException("Different matrix size"); }

		final int firstMatrixRows = firstMatrix.length;
		final int firstMatrixCols = firstMatrix[0].length;
		final int secondMatrixCols = secondMatrix[0].length;

		double[][] resultMatrix = new double[firstMatrixRows][secondMatrixCols];

		// fill with zeros
		for (int i = 0; i < firstMatrixRows; i++) {
			for (int j = 0; j < secondMatrixCols; j++) {
				resultMatrix[i][j] = 0.0;
			}
		}

		for (int i = 0; i < firstMatrixRows; i++) {
			for (int j = 0; j < secondMatrixCols; j++) {
				for (int k = 0; k < firstMatrixCols; k++) {
					resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
					// rounding
					resultMatrix[i][j] = BigDecimal.valueOf(resultMatrix[i][j])
							.setScale(3, RoundingMode.HALF_UP)
							.doubleValue();
				}
			}
		}
		return resultMatrix;
	}

	/**
	 * This method returns the inverse of the matrix
	 * <p>
	 * See {https://en.wikipedia.org/wiki/Invertible_matrix}
	 *
	 * @param matrix - input matrix
	 * @return inverse matrix for input matrix
	 */
	@Override
	public double[][] getInverseMatrix(double[][] matrix) {
		checkMatrixNonZero(matrix);
		checkMatrixIsSquare(matrix);

		final int rows = matrix.length;

		double[][] invertedMatrix = new double[rows][rows];
		double[][] tempMatrix = new double[rows-1][rows-1];

		for(int i = 0; i < rows; i++){
			for (int j = 0; j < rows; j++){
				for (int r = 0, l = 0; r < rows; r++){
					if(r == i) { continue;	}
					for (int k = 0, p = 0; k < matrix.length; k++){
						if(k==j) { continue;	}
						tempMatrix[l][p] = matrix[r][k];
						p++;
					}
					l++;
				}
				if(rows > 2) {
					invertedMatrix[i][j] = Math.pow((-1), ((i+1) + (j+1))) * getMatrixDeterminant(tempMatrix);
				} else {
					invertedMatrix[i][j] = Math.pow((-1), ((i+1) + (j+1))) * tempMatrix[0][0];
				}
			}
		}

		invertedMatrix = transpose(invertedMatrix);
		double determinant = getMatrixDeterminant(matrix);

		if(determinant == 0.0){	throw new MatrixProcessorException("Inverse matrix doesn't exist"); }

		for (int i = 0; i < invertedMatrix.length; i++){
			for (int j = 0; j < invertedMatrix.length; j++){
				invertedMatrix[i][j] = BigDecimal.valueOf(invertedMatrix[i][j]/determinant).setScale(3, RoundingMode.HALF_UP).doubleValue();
			}
		}
		return invertedMatrix;
	}

	/**
	 * This method returns the determinant of the matrix
	 * <p>
	 * See {https://en.wikipedia.org/wiki/Determinant}
	 *
	 * @param matrix - input matrix
	 * @return determinant of input matrix
	 */
	@Override
	public double getMatrixDeterminant(double[][] matrix) {
		checkMatrixNonZero(matrix);
		checkMatrixIsSquare(matrix);

		final int rows = matrix.length;
		final int cols = matrix[0].length;

		if(rows == 1) return matrix[0][0];
		if(rows == 2) return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);

		double determinant = 0;

		for (int i = 0; i < cols; i++) {
			double[][] temp = new double[rows - 1][cols - 1];

			for (int j = 1; j < rows; j++) {
				for (int k = 0; k < cols; k++) {
					if (k < i) {
						temp[j-1][k] = matrix[j][k];
					} else if (k > i) {
						temp[j-1][k-1] = matrix[j][k];
					}
				}
			}
			determinant += matrix[0][i] *  Math.pow (-1, i) * getMatrixDeterminant(temp);
		}
		return determinant;
	}

	void checkMatrixNonZero(double[][] matrix) {
		if (matrix == null || matrix.length == 0) {
				throw new MatrixProcessorException("Matrix is zero");
		}
	}

	void checkMatrixIsSquare(double[][] matrix) {
		if(matrix.length != matrix[0].length) {
			throw new MatrixProcessorException("Matrix is not square");
		}
	}
}