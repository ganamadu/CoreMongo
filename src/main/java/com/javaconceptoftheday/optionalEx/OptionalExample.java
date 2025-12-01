package com.javaconceptoftheday.optionalEx;

import java.util.Optional;

public class OptionalExample {

    static class User {
        private String name;
        private Address address;

        private User(String name, Address address) {
            this.name = name;
            this.address = address;
        }

        public Optional<Address> getAddress() {
            return Optional.ofNullable(address);
        }

        public String getName() {
            return  name;
        }

    }

    static class Address {
        private String city;
        private String country;

        public Address(String city, String country) {
            this.city = city;
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public String getCountry() {
            return country;
        }

    }

    public static void main(String args[]) {

        User user = new User("User1", new Address("Hyderabad", "India"));
        User user1 = new User("User2", null);

        String city = user.getAddress().map(Address::getCity)
                .orElse("Unknown");
        System.out.println("City: "+city);

        // Good practices:
        // 1. orElse - provide default value
        String city1 = user1.getAddress().map(Address::getCity)
                .orElse("Unknown");
        System.out.println("City: "+city1);

        // 2. orElseGet - lazy evaluation
        String city2 = user1.getAddress().map(Address::getCity)
                .orElseGet(() -> {
                   System.out.println("Computing default value...");
                   return "Unknown City";
                });
                System.out.println("City: "+city2);
        // 3. orElseThrow
        try {
            String city3 = user1.getAddress().map(Address::getCity)
                    .orElseThrow(() -> new IllegalStateException("Address not found."));
        }catch (IllegalStateException e) {
            System.out.println("Exception: "+e.getMessage());
        }
        // 4. ifPresent - execute action if present
        user1.getAddress().map(Address::getCity)
                .ifPresent(printCity->System.out.println("City found:"+printCity));

        //ifPresentOrElse (Java 9+)
        user1.getAddress().map(Address::getCity)
                .ifPresentOrElse(printCity -> System.out.println("City: "+printCity),
                        ()->System.out.println("Address Not Found."));
        // 7. Chain multiple Optionals
        Optional<String> countryCode = user1.getAddress()
                .map(Address::getCountry)
                .map(String::toUpperCase)
                .map(country->country.substring(0,2));
            System.out.println("Country Code: "+countryCode.orElse("N/A"));
    }

}
