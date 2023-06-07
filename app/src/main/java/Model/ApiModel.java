package Model;

import java.util.List;

public class ApiModel {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private Collection collections;

        public Product getProduct() {
            return products;
        }

        public void setProduct(Product product) {
            this.products = product;
        }

        private Product products;

        public Collection getCollection() {
            return collections;
        }

        public void setCollection(Collection collections) {
            this.collections = collections;
        }

        public static class Product{
            public List<Collection.Edges> getEdges() {
                return edges;
            }

            public void setEdges(List<Collection.Edges> edges) {
                this.edges = edges;
            }

            public List<Collection.Edges> edges;
        }

        public static class Collection {
            public List<Edges> getEdge() {
                return edges;
            }

            public void setEdge(List<Edges> edge) {
                this.edges = edge;
            }

            List<Edges> edges;

            public static class Edges{
                Node node;

                public Node getNode() {
                    return node;
                }

                public void setNode(Node node) {
                    this.node = node;
                }

                public static class Node{
                    String id;
                    String title;
                    String description;

                    Image featuredImage;
                    Image image;

                    public void setPrice(Price price) {
                        this.price = price;
                    }

                    public Price getPrice() {
                        return price;
                    }

                    Price price;

                    public static class Price{
                        float amount;
                        String currencyCode;

                        public float getAmount() {
                            return amount;
                        }

                        public void setAmount(float amount) {
                            this.amount = amount;
                        }

                        public String getCurrencyCode() {
                            return currencyCode;
                        }

                        public void setCurrencyCode(String currencyCode) {
                            this.currencyCode = currencyCode;
                        }
                    }

                    public Variant getVariant() {
                        return variants;
                    }

                    public void setVariant(Variant variant) {
                        this.variants = variant;
                    }

                    Variant variants;



                    public Image getFeaturedImage() {
                        return featuredImage;
                    }

                    public void setFeaturedImage(Image featuredImage) {
                        this.featuredImage = featuredImage;
                    }



                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public Image getImage() {
                        return image;
                    }

                    public void setImage(Image image) {
                        this.image = image;
                    }



                    public static class Image{
                        String id;
                        String url;


                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }

                    }

                    public static class Variant{
                        public List<Edges> getEdges() {
                            return edges;
                        }

                        public void setEdges(List<Edges> edges) {
                            this.edges = edges;
                        }

                        List<Edges> edges;
                    }


                }
            }
        }
    }



}
