package jarekjal.codewars.kyu5;

import java.util.List;

public class PaginationHelper<I> {

    private final List<I> collection;
    private final int itemsPerPage;
    private final int pageCount;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        if (itemsPerPage <= 0 || collection == null) throw new IllegalArgumentException();
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
        this.pageCount = calculatePageCount();
    }

    private int calculatePageCount() {
        return (int) Math.ceil((double) itemCount() / itemsPerPage);
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return pageCount;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex < 0 || pageIndex >= pageCount()) return -1;
        int completePagesCount = itemCount() / itemsPerPage;
        int incompletePageItemCount = itemCount() % itemsPerPage;
        return pageIndex < completePagesCount || incompletePageItemCount == 0 ? itemsPerPage : incompletePageItemCount;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        return itemIndex < 0 || itemIndex >= itemCount() ? -1 : itemIndex / itemsPerPage;
    }
}