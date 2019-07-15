package com.example.event;





    public class Model {

        private String Image;
        private String Title;
        private String Description;
        private String Descrip;
        private String Price;
        private String Delivery;
        private String d_id;






        public Model(String image, String Title, String Description, String Delivery, String Price, String d_id) {
            this.d_id = d_id;
            this.Image = image;
            this.Title = Title;
            this.Description = Description;
            this.Delivery = Delivery;
            this.Price = Price;

        }


        public String getImage() {

            return Image;
        }

        public void setImage(String image) {
            Image = image;
        }


        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public String getPrice() {
            return Price;
        }

        public void setPrice(String Price) {
            this.Price = Price;
        }

        public String getDelivery() {
            return Delivery;
        }

        public void setDelivery(String Delivery) {
            this.Delivery = Delivery;
        }


    }




