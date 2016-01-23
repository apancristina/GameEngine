(function(angular) {
  var AppController = function($scope, Player) {
    Player.query(function(response) {
      $scope.players = response?  response.players : [];
    });
    
    $scope.addPlayer = function(name) {
      new Player({
        name: name,
        checked:false
      }).$save(function(player) {
       console.log(player)
       console.log($scope.players)
      });
      $scope.newPlayer = "";
    };
    
    $scope.updatePlayer = function(player) {
      player.$update();
    };
    
    $scope.deletePlayer = function(player) {
      player.$remove(function() {
        $scope.players.splice($scope.players.indexOf(player), 1);
      });
    };
  };
  
  AppController.$inject = ['$scope', 'Player'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));