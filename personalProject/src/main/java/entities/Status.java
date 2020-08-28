package entities;

public enum Status {
    PENDING {
        public String toString() {
            return "Pending";           //default
        }
    },

    DELETED {
        public String toString() {
            return "Deleted";
        }
    },

    COMPLETED {
        public String toString() {
            return "Completed";
        }
    }
}
