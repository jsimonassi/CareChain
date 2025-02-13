import React from 'react';
import {PreAuthStack} from './PreAuthRoutes';
import {PostAuthStack} from './PostAuthRoutes';
import {NavigationContainer} from '@react-navigation/native';

export const CurrentStack = () => {
  const loggedWithMetamask = false;

  if (!loggedWithMetamask) {
    return <PreAuthStack />;
  }

  return <PostAuthStack />;
};

export const MainRouter = () => {
  return (
    <NavigationContainer>
      <CurrentStack />
    </NavigationContainer>
  );
};
